package com.example.todoapplication.controller;

import com.example.todoapplication.entity.Todo;
import com.example.todoapplication.repository.TodoRepository;
import com.example.todoapplication.repository.UserRepository;
import com.example.todoapplication.request.AddTodoRequest;
import com.example.todoapplication.request.AddUserRequest;
import com.example.todoapplication.services.UserService;
import lombok.AllArgsConstructor;
import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private final UserService userService;

    @PostMapping("/add")
    public ResponseEntity<?> addNewUser(@RequestBody AddUserRequest request){
        try {
            return ResponseEntity.ok().body(userService.createUser(request));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }

    @GetMapping("/find-one/{id}")
    public ResponseEntity<?> getUser(@PathVariable String id){
        try {
           return ResponseEntity.ok().body(userService.findUserById(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }
}
