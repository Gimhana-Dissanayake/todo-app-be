package com.todo.taskManager.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.todo.taskManager.models.Todo;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUsername(String username);
}
