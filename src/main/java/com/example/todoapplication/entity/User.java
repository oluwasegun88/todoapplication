package com.example.todoapplication.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Data
public class User {
    @Id
    private String id;

    private String userName;
    private String password;
    private List<Todo> todoList = new ArrayList<>();

}
