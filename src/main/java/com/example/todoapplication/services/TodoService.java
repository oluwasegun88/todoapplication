package com.example.todoapplication.services;

import com.example.todoapplication.entity.Todo;
import com.example.todoapplication.entity.User;
import com.example.todoapplication.repository.TodoRepository;
import com.example.todoapplication.request.AddTodoRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserService userService;
    public Todo addTodo(AddTodoRequest addTodoRequest) throws Exception {
        validateAddTodoRequest(addTodoRequest);
        Todo todo =  new Todo();
        todo.setContent(addTodoRequest.getContent());
        User user = userService.findUserByUserName(addTodoRequest.getUserName());
        todo.setUserId(user.getId());
        Todo savedTodo =  todoRepository.save(todo);

        user.getTodoList().add(savedTodo);
        userService.saveUser(user);
        return savedTodo;
    }

    private void validateAddTodoRequest(AddTodoRequest addTodoRequest) throws Exception {
        if (addTodoRequest.getContent().isBlank() || addTodoRequest.getContent().isEmpty()){
            throw new Exception("Todo content cannot be empty or blank");
        }
        if (addTodoRequest.getUserName().isBlank() || addTodoRequest.getUserName().isEmpty()){
            throw new Exception("Username cannot be empty or blank");
        }
    }

    public Todo setTodoToDone(String id) throws Exception {
        if (id.isBlank() || id.isEmpty()){
            throw new Exception("Todo id cannot be blank");
        }
        Optional<Todo> foundTodo = todoRepository.findById(id);
        if (foundTodo.isEmpty()){
            throw new Exception("Todo not found");
        }
        Todo todo = foundTodo.get();
        todo.setCompleted(true);
        User user = userService.findUserById(todo.getUserId());
        List<Todo> todoList = user.getTodoList();
        for (Todo t: todoList) {
            if (t.getId().equals(todo.getId())){
                t.setCompleted(true);
                user.setTodoList(todoList);
                userService.saveUser(user);
            }
        }
        return todoRepository.save(todo);
    }
}
