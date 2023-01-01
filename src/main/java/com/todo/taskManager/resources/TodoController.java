package com.todo.taskManager.resources;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.todo.taskManager.models.Todo;
import com.todo.taskManager.services.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/users/{username}/todos")
    public List<Todo> getAllTodos() {

        return this.todoService.findAll();

    }

    @GetMapping("/users/{username}/todos/{id}")
    public Todo getTodoById(@PathVariable long id) {

        return this.todoService.findById(id);

    }

    @DeleteMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable String username, @PathVariable long id) {

        Todo todo = todoService.deleteById(id);

        if (todo != null) {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PutMapping("/users/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
            @RequestBody Todo todo) {
        System.out.println("CAME HERE");
        Todo todoUpdated = todoService.save(todo);

        return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);

    }

    @PostMapping("/users/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username,
            @RequestBody Todo todo) {

        Todo createdTodo = todoService.save(todo);

        return new ResponseEntity<Todo>(createdTodo, HttpStatus.OK);

    }

}
