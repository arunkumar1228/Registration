package com.example.security.Mcq.User.service;

import com.example.security.Mcq.User.dto.UserDto;
import com.example.security.Mcq.User.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    String saveUser(UserDto userDto);

    String deleteUserById(Long id);

    List<UserDto> getAllUser();

    Optional<User> getUserById(Long id);
}
