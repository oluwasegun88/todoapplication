package com.example.todoapplication.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Todo {

    @Id
    private String  id;
    private String userId;
    private String content;
    private boolean completed ;
}
