package com.usersystem.app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.usersystem.app.model.UserDto;

@Service
public interface UserService {

    UserDto saveUser(UserDto user);

    List<UserDto> getAllUsers();

}
