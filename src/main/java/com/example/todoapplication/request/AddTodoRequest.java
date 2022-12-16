package com.example.todoapplication.request;

import lombok.Data;

@Data
public class AddTodoRequest {
    private String content;
    private String userName;
}
