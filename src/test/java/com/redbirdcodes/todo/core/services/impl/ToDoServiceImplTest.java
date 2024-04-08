package com.redbirdcodes.todo.core.services.impl;

import com.redbirdcodes.todo.core.dto.ToDoDTO;
import com.redbirdcodes.todo.core.exceptions.NoIdFoundException;
import com.redbirdcodes.todo.core.exceptions.NotFoundException;
import com.redbirdcodes.todo.persistence.entities.ToDo;
import com.redbirdcodes.todo.persistence.entities.TodoStatus;
import com.redbirdcodes.todo.persistence.repositories.ToDoManualRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ToDoServiceImplTest {

    @InjectMocks
    ToDoServiceImpl toDoService;

    @Mock
    ToDoManualRepository repository;
    
    @Spy
    ModelMapper modelMapper = new ModelMapper();

    @Test
    void getAllToDos() {
        List<ToDo> list = new ArrayList<>();
        list.add(createToDo(1L, "One", "One ToDo", TodoStatus.PENDING));
        list.add(createToDo(2L, "Two", "Two ToDo", TodoStatus.PENDING));
        list.add(createToDo(3L, "Three", "Three ToDo", TodoStatus.PENDING));

        when(repository.findAll()).thenReturn(list);

        List<ToDoDTO> toDoDTOList = toDoService.getAllToDos();
        assertEquals(3, toDoDTOList.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void getAllToDosEmpty() {
        List<ToDo> list = new ArrayList<>();

        when(repository.findAll()).thenReturn(list);

        List<ToDoDTO> toDoDTOList = toDoService.getAllToDos();
        assertEquals(0, toDoDTOList.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    void getToDo() throws NotFoundException {
        Optional<ToDo> one = Optional.of(createToDo(1L, "One", "One ToDo", TodoStatus.PENDING));
        when(repository.findById(anyLong())).thenReturn(one);

        ToDoDTO toDoDTO = toDoService.getToDo(1L);
        verify(repository, times(1)).findById(anyLong());
    }

    @Test
    void getToDoNotFound() throws NotFoundException {
        Optional<ToDo> one = Optional.empty();
        when(repository.findById(anyLong())).thenReturn(one);

        assertThrows(NotFoundException.class, () -> toDoService.getToDo(1L));
        verify(repository, times(1)).findById(anyLong());
    }

    @Test
    void createToDo()  {

        doNothing().when(repository).save(any());

        ToDoDTO one = new ToDoDTO();
        one.setId(1L);
        one.setTitle("One");
        one.setDescription("One ToDo");
        one.setStatus("PENDING");

        toDoService.createToDo(one);
        verify(repository, times(1)).save(any());
    }

    @Test
    void deleteToDo() throws NotFoundException, NoIdFoundException {

        Optional<ToDo> one = Optional.of(createToDo(1L, "One", "One ToDo", TodoStatus.PENDING));
        when(repository.findById(anyLong())).thenReturn(one);

        doNothing().when(repository).deleteById(anyLong());

        toDoService.deleteToDo(1L);
        verify(repository, times(1)).deleteById(anyLong());
    }

    @Test
    void deleteToDoNotFound() throws NotFoundException, NoIdFoundException {

        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        assertThrows(NotFoundException.class, () -> toDoService.deleteToDo(1L));
    }

    @Test
    void deleteToDoNoIdFound() throws NotFoundException, NoIdFoundException {

        assertThrows(NoIdFoundException.class, () -> toDoService.deleteToDo(null));
    }

    @Test
    void updateToDo() throws NotFoundException, NoIdFoundException {

        Optional<ToDo> one = Optional.of(createToDo(1L, "One", "One ToDo", TodoStatus.PENDING));
        when(repository.findById(anyLong())).thenReturn(one);

        doNothing().when(repository).update(any());

        ToDoDTO oneDTO = new ToDoDTO();
        oneDTO.setId(1L);
        oneDTO.setTitle("One");
        oneDTO.setDescription("One ToDo");
        oneDTO.setStatus("PENDING");

        toDoService.updateToDo(1L, oneDTO);
        verify(repository, times(1)).update(any());
    }

    @Test
    void updateToDoNotFound() throws NotFoundException, NoIdFoundException {

        when(repository.findById(anyLong())).thenReturn(Optional.empty());

        ToDoDTO oneDTO = new ToDoDTO();
        oneDTO.setId(1L);
        oneDTO.setTitle("One");
        oneDTO.setDescription("One ToDo");
        oneDTO.setStatus("PENDING");

        assertThrows(NotFoundException.class, () -> toDoService.updateToDo(1L, oneDTO));
    }

    @Test
    void updateToDoNoIdFound() throws NotFoundException, NoIdFoundException {

        ToDoDTO oneDTO = new ToDoDTO();
        oneDTO.setId(null);
        oneDTO.setTitle("One");
        oneDTO.setDescription("One ToDo");
        oneDTO.setStatus("PENDING");

        assertThrows(NoIdFoundException.class, () -> toDoService.updateToDo(1L, oneDTO));
    }

    @Test
    void updateToDoNoIdFound2() throws NotFoundException, NoIdFoundException {

        ToDoDTO oneDTO = new ToDoDTO();
        oneDTO.setId(1L);
        oneDTO.setTitle("One");
        oneDTO.setDescription("One ToDo");
        oneDTO.setStatus("PENDING");

        assertThrows(NoIdFoundException.class, () -> toDoService.updateToDo(null, oneDTO));
    }

    @Test
    void updateToDoNoIdFound3() throws NotFoundException, NoIdFoundException {

        ToDoDTO oneDTO = new ToDoDTO();
        oneDTO.setId(1L);
        oneDTO.setTitle("One");
        oneDTO.setDescription("One ToDo");
        oneDTO.setStatus("PENDING");

        assertThrows(NoIdFoundException.class, () -> toDoService.updateToDo(2L, oneDTO));
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
