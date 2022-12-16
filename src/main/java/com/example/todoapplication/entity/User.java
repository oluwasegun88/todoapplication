package com.example.todoapplication.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    private long id;

    public User() {
    }

    private String userName;
    private String password;

    @OneToMany
    private List<Todo> todoList = new ArrayList<>();


    public User(long id, String userName, String password, List<Todo> todoList) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.todoList = todoList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Todo> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<Todo> todoList) {
        this.todoList = todoList;
    }
}
