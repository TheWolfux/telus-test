package com.redbirdcodes.todo.persistence.repositories.jdbc;

import com.redbirdcodes.todo.persistence.entities.ToDo;
import com.redbirdcodes.todo.persistence.repositories.ToDoManualRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ToDoManualRepositoryJDBC implements ToDoManualRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public List<ToDo> findAll() {
        return jdbcTemplate.query("SELECT ID,TITLE,DESCRIPTION,STATUS FROM TODOS", new BeanPropertyRowMapper<>(ToDo.class));
    }

    @Override
    public Optional<ToDo> findById(Long id) {
        try {
            // Find data by id
            List<ToDo> toDoList = jdbcTemplate.query("SELECT ID,TITLE,DESCRIPTION,STATUS FROM TODOS WHERE ID=?", new BeanPropertyRowMapper<>(ToDo.class), id);
            // check if found
            if (toDoList.isEmpty()) return Optional.empty();
            // If found, return it
            ToDo toDo = toDoList.get(0);
            return Optional.ofNullable(toDo);
        } catch(EmptyResultDataAccessException ere) {
            return Optional.empty();
        }

    }

    @Override
    public void save(ToDo toDo) {
        jdbcTemplate.update("INSERT INTO TODOS (TITLE, DESCRIPTION, STATUS) VALUES (?, ?, ?)", toDo.getTitle(), toDo.getDescription(), toDo.getStatus().name());
    }

    @Override
    public void update(ToDo toDo) {
        jdbcTemplate.update("UPDATE TODOS SET TITLE=?, DESCRIPTION=?, STATUS=? WHERE ID=?", toDo.getTitle(), toDo.getDescription(), toDo.getStatus().name(), toDo.getId());
    }

    @Override
    public void deleteById(Long id) {
        jdbcTemplate.update("DELETE FROM TODOS WHERE ID=?", id);
    }
}
