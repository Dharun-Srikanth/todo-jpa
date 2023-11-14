package com.jpa.todo.controller;


import com.jpa.todo.model.AppUser;
import com.jpa.todo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public AppUser getLoginUser(@RequestBody AppUser user){
        return userService.loginUser(user);
    }

    @RequestMapping("/register")
    public AppUser getRegisterUser(@RequestBody AppUser user){
        return userService.registerUser(user);
    }



}
