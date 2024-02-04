package com.usersystem.app.service.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.usersystem.app.entity.UserEntity;
import com.usersystem.app.model.UserDto;
import com.usersystem.app.repository.UserRepository;
import com.usersystem.app.service.UserService;

public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDto saveUser(UserDto userDto) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties(userDto, userEntity);
        userRepository.save(userEntity);
        return userDto;
    }

    @Override
    public List<UserDto> getAllUsers() {

        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDtoList = userEntities.stream().map(userEntity -> new UserDto(userEntity.getId(),
                userEntity.getFirstname(),
                userEntity.getLastname(),
                userEntity.getEmailId())).collect(Collectors.toList());
        return userDtoList;
    }

}
