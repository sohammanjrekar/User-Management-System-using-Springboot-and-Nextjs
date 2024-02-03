package com.usersystem.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.usersystem.app.model.UserDto;
import com.usersystem.app.service.UserService;

@RestController
@RequestMapping("/api/v1/")
public class UserController {
    // @Autowired
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public UserDto saveUser(@RequestBody UserDto user) {
        return userService.saveUser(user);
    }
}
