package com.redbirdcodes.todo;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.redbirdcodes.todo.core.dto.ToDoDTO;
import com.redbirdcodes.todo.persistence.entities.ToDo;
import com.redbirdcodes.todo.persistence.repositories.ToDoManualRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ToDoApplicationIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @Autowired
    private ToDoManualRepository repository;

    @Test
    void createDeleteToDo() throws Exception {
        // Create data
        ToDoDTO toDoDTO = createToDoDTO(null, "AutoTest", "Integration Data Test", "PENDING");
        mockMvc.perform(post("/todos").contentType("application/json")
                .content(objectMapper.writeValueAsString(toDoDTO))).andExpect(status().isOk());

        // AssertData is there
        Optional<ToDo> toDo = repository.findById(1L);
        assertTrue(toDo.isPresent());

        // Delete data
        mockMvc.perform(delete("/todos/1")).andExpect(status().isOk());

        // AssertData is deleted
        Optional<ToDo> toDo2 = repository.findById(1L);
        assertTrue(toDo2.isEmpty());

    }

    @Test
    void createGetUpdateDeleteToDo() throws Exception {
        // Create data
        ToDoDTO toDoDTO = createToDoDTO(null, "AutoTest", "Integration Data Test", "PENDING");
        mockMvc.perform(post("/todos").contentType("application/json")
                .content(objectMapper.writeValueAsString(toDoDTO))).andExpect(status().isOk());

        // AssertData is there
        Optional<ToDo> toDo = repository.findById(1L);
        assertTrue(toDo.isPresent());

        // Get data
        MvcResult getResult = mockMvc.perform(get("/todos/1")).andReturn();
        String getData = getResult.getResponse().getContentAsString();
        assertTrue(getData.contains("AutoTest"));

        // Update Data
        toDoDTO = createToDoDTO(1L, "UpdateTest", "Integration Data Test", "COMPLETED");
        mockMvc.perform(patch("/todos/1").contentType("application/json")
                .content(objectMapper.writeValueAsString(toDoDTO))).andExpect(status().isOk());

        // Get data
        MvcResult getResult2 = mockMvc.perform(get("/todos/1")).andReturn();
        String getData2 = getResult2.getResponse().getContentAsString();
        assertTrue(getData2.contains("UpdateTest"));

        // Delete data
        mockMvc.perform(delete("/todos/1")).andExpect(status().isOk());

        // AssertData is deleted
        Optional<ToDo> toDo2 = repository.findById(1L);
        assertTrue(toDo2.isEmpty());

        // Get list data
        MvcResult listResult = mockMvc.perform(get("/todos")).andReturn();
        String listData = listResult.getResponse().getContentAsString();
        assertEquals("[]", listData);
        assertEquals(200, listResult.getResponse().getStatus());

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
