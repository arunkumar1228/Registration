package com.example.security.Mcq.User.controller;

import com.example.security.Mcq.User.dto.UserDto;
import com.example.security.Mcq.User.entity.User;
import com.example.security.Mcq.User.service.UserServiceImpl;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping(value = "/api/user")

public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }


    @PostMapping(value = "/insertData", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> addEmployee(@RequestBody UserDto userDto) {
        String serviceResponse = userService.saveUser(userDto);
        if (serviceResponse != null) {
            return ResponseEntity.ok(serviceResponse);
        } else {
            return new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/getUserById")
    public Optional<User> getOffers(Long id){
        return userService.getUserById(id);
    }

    @GetMapping(value = "/getAllUser")
    public List<UserDto> getAllUser() {
        return userService.getAllUser();
    }

    @DeleteMapping("/deleteUserById")
    public String deleteUserById(@RequestParam("id") Long id) {
        return userService.deleteUserById(id);
    }
}
