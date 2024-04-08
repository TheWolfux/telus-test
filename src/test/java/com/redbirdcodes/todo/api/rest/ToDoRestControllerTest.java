package com.redbirdcodes.todo.api.rest;

import com.redbirdcodes.todo.core.dto.ToDoDTO;
import com.redbirdcodes.todo.core.exceptions.NoIdFoundException;
import com.redbirdcodes.todo.core.exceptions.NotFoundException;
import com.redbirdcodes.todo.core.services.ToDoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ToDoRestControllerTest {

    @InjectMocks
    ToDoRestController controller;

    @Mock
    ToDoService toDoService;

    @Test
    void getAllToDos() {
        List<ToDoDTO> list = new ArrayList<>();
        list.add(createToDoDTO(1L, "One", "One ToDo", "PENDING"));
        list.add(createToDoDTO(2L, "Two", "Two ToDo", "PENDING"));
        list.add(createToDoDTO(3L, "Three", "Three ToDo", "HOLD"));

        when(toDoService.getAllToDos()).thenReturn(list);

        ResponseEntity<?> response = controller.getAllToDos();
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(toDoService, times(1)).getAllToDos();
    }

    @Test
    void getToDo() throws NotFoundException {
        ToDoDTO toDoDTO = createToDoDTO(1L, "One", "One ToDo", "PENDING");

        when(toDoService.getToDo(anyLong())).thenReturn(toDoDTO);

        ResponseEntity<?> response = controller.getToDo(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(toDoService, times(1)).getToDo(anyLong());
    }

    @Test
    void getToDoNotFound() throws NotFoundException {

        when(toDoService.getToDo(anyLong())).thenThrow(NotFoundException.class);

        ResponseEntity<?> response = controller.getToDo(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(toDoService, times(1)).getToDo(anyLong());
    }

    @Test
    void createToDo()  {
        ToDoDTO toDoDTO = createToDoDTO(1L, "One", "One ToDo", "PENDING");

        doNothing().when(toDoService).createToDo(any());

        ResponseEntity<?> response = controller.createToDo(toDoDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(toDoService, times(1)).createToDo(any());
    }

    @Test
    void createToDoNotFound() {

        doThrow(RuntimeException.class).when(toDoService).createToDo(any());

        ToDoDTO toDoDTO = createToDoDTO(1L, "One", "One ToDo", "PENDING");

        ResponseEntity<?> response = controller.createToDo(toDoDTO);
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        verify(toDoService, times(1)).createToDo(any());
    }

    @Test
    void updateToDo() throws NotFoundException, NoIdFoundException {
        doNothing().when(toDoService).updateToDo(anyLong(), any());

        ToDoDTO toDoDTO = createToDoDTO(1L, "One", "One ToDo", "PENDING");

        ResponseEntity<?> response = controller.updateToDo(1L, toDoDTO);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(toDoService, times(1)).updateToDo(anyLong(), any());
    }

    @Test
    void updateToDoNotFound() throws NotFoundException, NoIdFoundException {

        doThrow(NotFoundException.class).when(toDoService).updateToDo(anyLong(), any());

        ToDoDTO toDoDTO = createToDoDTO(1L, "One", "One ToDo", "PENDING");

        ResponseEntity<?> response = controller.updateToDo(1L, toDoDTO);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(toDoService, times(1)).updateToDo(anyLong(), any());
    }

    @Test
    void updateToDoNoIdFound() throws NotFoundException, NoIdFoundException {

        doThrow(NoIdFoundException.class).when(toDoService).updateToDo(anyLong(), any());

        ToDoDTO toDoDTO = createToDoDTO(1L, "One", "One ToDo", "PENDING");

        ResponseEntity<?> response = controller.updateToDo(1L, toDoDTO);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(toDoService, times(1)).updateToDo(anyLong(), any());
    }

    @Test
    void deleteToDo() throws NotFoundException, NoIdFoundException {
        doNothing().when(toDoService).deleteToDo(anyLong());

        ResponseEntity<?> response = controller.deleteToDo(1L);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        verify(toDoService, times(1)).deleteToDo(anyLong());
    }

    @Test
    void deleteToDoNotFound() throws NotFoundException, NoIdFoundException {

        doThrow(NotFoundException.class).when(toDoService).deleteToDo(anyLong());

        ResponseEntity<?> response = controller.deleteToDo(1L);
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
        verify(toDoService, times(1)).deleteToDo(anyLong());
    }

    @Test
    void deleteToDoNoIdFound() throws NotFoundException, NoIdFoundException {

        doThrow(NoIdFoundException.class).when(toDoService).deleteToDo(anyLong());

        ResponseEntity<?> response = controller.deleteToDo(1L);
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        verify(toDoService, times(1)).deleteToDo(anyLong());
    }

    private ToDoDTO createToDoDTO(Long id, String title, String description, String status) {
        ToDoDTO toDo = new ToDoDTO();
        toDo.setId(id);
        toDo.setTitle(title);
        toDo.setDescription(description);
        toDo.setStatus(status);
        return toDo;
    }
}
