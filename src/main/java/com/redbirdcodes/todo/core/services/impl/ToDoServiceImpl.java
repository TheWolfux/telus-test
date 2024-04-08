package com.redbirdcodes.todo.core.services.impl;

import com.redbirdcodes.todo.core.dto.ToDoDTO;
import com.redbirdcodes.todo.core.exceptions.NoIdFoundException;
import com.redbirdcodes.todo.core.exceptions.NotFoundException;
import com.redbirdcodes.todo.core.services.ToDoService;
import com.redbirdcodes.todo.persistence.entities.ToDo;
import com.redbirdcodes.todo.persistence.entities.TodoStatus;
import com.redbirdcodes.todo.persistence.repositories.ToDoManualRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ToDoServiceImpl implements ToDoService {

    @Autowired
    ToDoManualRepository toDoRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<ToDoDTO> getAllToDos() {
        // Find all from Database
        List<ToDo> toDoList = toDoRepository.findAll();
        // Convert to DTO
        return toDoList.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public ToDoDTO getToDo(Long id) throws NotFoundException {
        // Find from database
        Optional<ToDo> toDo = toDoRepository.findById(id);
        // Throw exception if not found
        if (toDo.isEmpty()) throw new NotFoundException();
        // Convert To DTO
        return convertToDto(toDo.get());
    }

    @Override
    public void createToDo(ToDoDTO toDoDTO) {
        // Convert to Entity;
        ToDo toDo = convertFromDto(toDoDTO);
        // Save in database
        toDoRepository.save(toDo);
    }

    @Override
    public void updateToDo(Long id, ToDoDTO toDoDTO) throws NoIdFoundException, NotFoundException {
        // Check for nulls
        if (toDoDTO.getId() == null || id == null) throw new NoIdFoundException();
        // Check that both id are the same
        if (!id.equals(toDoDTO.getId())) throw new NoIdFoundException();
        // Search if exists in database
        Optional<ToDo> toDoCheck = toDoRepository.findById(toDoDTO.getId());
        if (toDoCheck.isEmpty()) throw new NotFoundException();
        // Convert to entity
        ToDo toDo = convertFromDto(toDoDTO);
        // Update in database
        toDoRepository.update(toDo);
    }

    @Override
    public void deleteToDo(Long id) throws NoIdFoundException, NotFoundException {
        // Search if exists in database
        if (id == null) throw new NoIdFoundException();
        Optional<ToDo> toDoCheck = toDoRepository.findById(id);
        if (toDoCheck.isEmpty()) throw new NotFoundException();
        // Delete in database
        toDoRepository.deleteById(id);
    }


    private ToDoDTO convertToDto(ToDo toDo) {
        ToDoDTO toDoDTO = modelMapper.map(toDo, ToDoDTO.class);
        toDoDTO.setStatus(toDo.getStatus().name());
        return toDoDTO;
    }

    private ToDo convertFromDto(ToDoDTO toDoDTO) {
        ToDo toDo = modelMapper.map(toDoDTO, ToDo.class);
        toDo.setStatus(TodoStatus.valueOf(toDoDTO.getStatus().toUpperCase()));
        return toDo;
    }

}
