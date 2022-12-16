package com.example.todoapplication.repository;

import com.example.todoapplication.entity.Todo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends MongoRepository<Todo,String> {
}
