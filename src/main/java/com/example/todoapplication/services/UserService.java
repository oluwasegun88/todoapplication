package com.example.todoapplication.services;

import com.example.todoapplication.entity.User;
import com.example.todoapplication.repository.UserRepository;
import com.example.todoapplication.request.AddUserRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(AddUserRequest request) throws Exception {
        validateAddUserRequest(request);

        User newUser = new User();
        newUser.setUserName(request.getUserName());
        newUser.setPassword(request.getPassword());
        return saveUser(newUser);
    }

    public User saveUser(User user){
        return userRepository.save(user);
    }
    private void validateAddUserRequest(AddUserRequest request) throws Exception {
        if (request.getUserName().isBlank() || request.getUserName().isEmpty()){
            throw new Exception("userName cannot be empty or blank");
        }
        if (request.getPassword().isEmpty() || request.getPassword().isBlank()){
            throw new Exception("password for user cannot be blank");
        }
    }

    public User findUserByUserName(String userName) throws Exception {
        if (userName.isEmpty() || userName.isBlank()){
            throw new Exception("User name cannot be empty or blank");
        }
        Optional<User> foundUser =  userRepository.findUserByUserName(userName);
        if (foundUser.isEmpty()){
            throw new Exception("User does not exist!");
        }
        return foundUser.get();
    }

    public User findUserById(String id) throws Exception {
        if (id.isEmpty()|| id.isBlank()){
            throw new Exception("User id cannot be blank");
        }

        Optional<User> foundUser = userRepository.findById(id);

        if (foundUser.isEmpty()){
            throw new Exception("user not found");
        }
        return foundUser.get();
    }
}
