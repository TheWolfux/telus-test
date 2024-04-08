package com.redbirdcodes.todo.persistence.repositories;

import com.redbirdcodes.todo.persistence.entities.ToDo;

import java.util.List;
import java.util.Optional;

public interface ToDoManualRepository {

    List<ToDo> findAll();
    Optional<ToDo> findById(Long id);
    void save(ToDo toDo);
    void update(ToDo toDo);
    void deleteById(Long id);
}
