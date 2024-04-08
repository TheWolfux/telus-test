package com.redbirdcodes.todo.api.rest;

import com.redbirdcodes.todo.core.dto.ToDoDTO;
import com.redbirdcodes.todo.core.exceptions.NoIdFoundException;
import com.redbirdcodes.todo.core.exceptions.NotFoundException;
import com.redbirdcodes.todo.core.services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ToDoRestController {

    @Autowired
    ToDoService toDoService;

    @GetMapping("/todos")
    public ResponseEntity<?> getAllToDos() {
        List<ToDoDTO> toDoDTOList = toDoService.getAllToDos();
        return new ResponseEntity<>(toDoDTOList, HttpStatus.OK);
    }

    @GetMapping("/todos/{id}")
    public ResponseEntity<?> getToDo(@PathVariable long id) {
        try {
            ToDoDTO toDoDTO = toDoService.getToDo(id);
            return new ResponseEntity<>(toDoDTO, HttpStatus.OK);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(NotFoundException.MESSAGE, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/todos")
    public ResponseEntity<?> createToDo(@RequestBody ToDoDTO toDoDTO) {
        try {
            toDoService.createToDo(toDoDTO);
            return new ResponseEntity<>("Information saved successfully.", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Unknown error.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/todos/{id}")
    public ResponseEntity<?> updateToDo(@PathVariable long id, @RequestBody ToDoDTO toDoDTO) {
        try {
            toDoService.updateToDo(id, toDoDTO);
            return new ResponseEntity<>("Information updated successfully.", HttpStatus.OK);
        } catch (NoIdFoundException e) {
            return new ResponseEntity<>(NoIdFoundException.MESSAGE, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(NotFoundException.MESSAGE, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/todos/{id}")
    public ResponseEntity<?> deleteToDo(@PathVariable long id) {
        try {
            toDoService.deleteToDo(id);
            return new ResponseEntity<>("Information deleted successfully.", HttpStatus.OK);
        } catch (NoIdFoundException e) {
            return new ResponseEntity<>(NoIdFoundException.MESSAGE, HttpStatus.BAD_REQUEST);
        } catch (NotFoundException e) {
            return new ResponseEntity<>(NotFoundException.MESSAGE, HttpStatus.NOT_FOUND);
        }
    }
}
