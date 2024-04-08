package com.redbirdcodes.todo.core.services;

import com.redbirdcodes.todo.core.dto.ToDoDTO;
import com.redbirdcodes.todo.core.exceptions.NoIdFoundException;
import com.redbirdcodes.todo.core.exceptions.NotFoundException;

import java.util.List;

public interface ToDoService {

    public List<ToDoDTO> getAllToDos();
    public ToDoDTO getToDo(Long id) throws NotFoundException;
    public void createToDo(ToDoDTO toDoDTO);
    public void updateToDo(Long id, ToDoDTO toDoDTO) throws NoIdFoundException, NotFoundException;
    public void deleteToDo(Long id) throws NoIdFoundException, NotFoundException;
}
