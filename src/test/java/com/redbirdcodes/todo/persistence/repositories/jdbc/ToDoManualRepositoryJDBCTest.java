package com.redbirdcodes.todo.persistence.repositories.jdbc;

import com.redbirdcodes.todo.persistence.entities.ToDo;
import com.redbirdcodes.todo.persistence.entities.TodoStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ToDoManualRepositoryJDBCTest {

    @InjectMocks
    ToDoManualRepositoryJDBC repository;

    @Mock
    JdbcTemplate jdbcTemplate;

    @Test
    void testFindAll() {
        List<ToDo> list = new ArrayList<>();
        list.add(createToDo(1L, "One", "One ToDo", TodoStatus.PENDING));
        list.add(createToDo(2L, "Two", "Two ToDo", TodoStatus.PENDING));
        list.add(createToDo(3L, "Three", "Three ToDo", TodoStatus.PENDING));

        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class))).thenReturn(list);

        List<ToDo> toDoList = repository.findAll();
        assertEquals(3, toDoList.size());
        verify(jdbcTemplate, times(1)).query(anyString(), any(BeanPropertyRowMapper.class));
    }

    @Test
    void testFindAllEmpty() {
        List<ToDo> list = new ArrayList<>();

        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class))).thenReturn(list);

        List<ToDo> toDoList = repository.findAll();
        assertEquals(0, toDoList.size());
        verify(jdbcTemplate, times(1)).query(anyString(), any(BeanPropertyRowMapper.class));
    }

    @Test
    void testFindById() {
        List<ToDo> list = new ArrayList<>();
        list.add(createToDo(1L, "One", "One ToDo", TodoStatus.PENDING));

        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class), anyLong())).thenReturn(list);

        Optional<ToDo> toDo = repository.findById(1L);
        assertTrue(toDo.isPresent());
        verify(jdbcTemplate, times(1)).query(anyString(), any(BeanPropertyRowMapper.class), anyLong());
    }

    @Test
    void testFindByIdEmpty() {
        List<ToDo> list = new ArrayList<>();
        list.add(createToDo(1L, "One", "One ToDo", TodoStatus.PENDING));

        when(jdbcTemplate.query(anyString(), any(BeanPropertyRowMapper.class), anyLong())).thenThrow(new EmptyResultDataAccessException(1));
        Optional<ToDo> toDo = repository.findById(1L);
        assertTrue(toDo.isEmpty());
        verify(jdbcTemplate, times(1)).query(anyString(), any(BeanPropertyRowMapper.class), anyLong());
    }

    @Test
    void testSave() {

        when(jdbcTemplate.update(anyString(), any(), any(), any())).thenReturn(1);

        ToDo one = createToDo(null, "One", "One ToDo", TodoStatus.PENDING);
        repository.save(one);
        verify(jdbcTemplate, times(1)).update(anyString(), any(), any(), any());
    }

    @Test
    void testUpdate() {

        when(jdbcTemplate.update(anyString(), any(), any(), any(), any())).thenReturn(1);

        ToDo one = createToDo(1L, "One", "One ToDo", TodoStatus.PENDING);
        repository.update(one);
        verify(jdbcTemplate, times(1)).update(anyString(), any(), any(), any(), any());
    }

    @Test
    void testDelete() {

        when(jdbcTemplate.update(anyString(), (Object) any())).thenReturn(1);

        repository.deleteById(1L);
        verify(jdbcTemplate, times(1)).update(anyString(), (Object) any());
    }

    private ToDo createToDo(Long id, String title, String description, TodoStatus status) {
        ToDo toDo = new ToDo();
        toDo.setId(id);
        toDo.setTitle(title);
        toDo.setDescription(description);
        toDo.setStatus(status);
        return toDo;
    }
}
