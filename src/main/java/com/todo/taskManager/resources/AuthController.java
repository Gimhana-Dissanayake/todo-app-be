package com.todo.taskManager.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.todo.taskManager.models.User;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @GetMapping(path = "/basicauth")
    public ResponseEntity<User> authController() {

        return ResponseEntity.ok(new User("Gim"));
    }

}
