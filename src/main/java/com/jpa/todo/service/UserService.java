package com.jpa.todo.service;

import com.jpa.todo.model.AppUser;
import com.jpa.todo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;


    public AppUser loginUser(AppUser user) {
        return userRepository.findUserByUsernameAndPassword(user.getUsername(), user.getPassword());
    }

    public AppUser registerUser(AppUser user) {
        userRepository.save(user);
        return user;
    }

}
