package com.todo.taskManager.resources;

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
import com.todo.taskManager.repositories.TodoRepository;
import com.todo.taskManager.services.TodoService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/{username}/todos")
    public ResponseEntity<List<Todo>> getAllTodos(@PathVariable String username) {

        List<Todo> todoList = todoRepository.findByUsername(username);

        return new ResponseEntity<List<Todo>>(todoList, HttpStatus.OK);

    }

    @GetMapping("/{username}/todos/{id}")
    public ResponseEntity<Todo> getTodoById(@PathVariable String username, @PathVariable long id) {

        Todo todo = todoRepository.findById(id).get();

        return new ResponseEntity<Todo>(todo, HttpStatus.OK);

    }

    @DeleteMapping("/{username}/todos/{id}")
    public ResponseEntity<Todo> deleteTodo(@PathVariable String username, @PathVariable long id) {

        Todo todo = todoService.deleteById(id);

        if (todo != null) {
            return new ResponseEntity<>(todo, HttpStatus.OK);
        }

        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);

    }

    @PutMapping("/{username}/todos/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username, @PathVariable long id,
            @RequestBody Todo todo) {
        Todo todoUpdated = todoService.save(todo);

        return new ResponseEntity<Todo>(todoUpdated, HttpStatus.OK);

    }

    @PostMapping("/{username}/todos")
    public ResponseEntity<Todo> createTodo(@PathVariable String username,
            @RequestBody Todo todo) {

        Todo createdTodo = todoService.save(todo);

        return new ResponseEntity<Todo>(createdTodo, HttpStatus.OK);

    }

}
