package com.redbirdcodes.todo.persistence.repositories;

import com.redbirdcodes.todo.persistence.entities.ToDo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {
}
