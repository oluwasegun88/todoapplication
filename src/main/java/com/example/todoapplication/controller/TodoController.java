package com.example.todoapplication.controller;

import com.example.todoapplication.entity.Todo;
import com.example.todoapplication.request.AddTodoRequest;
import com.example.todoapplication.services.TodoService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/todo")
@AllArgsConstructor
public class TodoController {
    private final TodoService todoService;

    @PostMapping("/add")
    public ResponseEntity<?> addTodo(@RequestBody AddTodoRequest todoRequest){
        try {
            return ResponseEntity.ok().body(todoService.addTodo(todoRequest));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }

    @PatchMapping("/done/{id}")
    public ResponseEntity<?> setTodoToDone(@PathVariable String id){
        try {
            return ResponseEntity.ok().body(todoService.setTodoToDone(id));
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getLocalizedMessage());
        }
    }
}
