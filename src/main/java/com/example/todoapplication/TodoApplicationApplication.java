package com.example.todoapplication;

import com.example.todoapplication.entity.Todo;
import com.example.todoapplication.repository.TodoRepository;
import com.example.todoapplication.repository.UserRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoapplicationApplication implements CommandLineRunner{

    public static void main(String[] args) {
        SpringApplication.run(TodoapplicationApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public void run(String... args) throws Exception {



        User user = new User();
        user.setId(1L);
        user.setPassword("Should be hashed");
        user.setUsername("John");

        Todo todo = new Todo();
        todo.setId(1L);
        todo.setContent("Upload video to Y1");


        user.getTodoList().add(todo);

        todoRepository.save(todo);
        userRepository.save(user);
    }
}
