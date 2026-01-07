package com.omkar.jobtracker.controller;

import org.springframework.web.bind.annotation.*;
import java.util.List;

import com.omkar.jobtracker.entity.User;
import com.omkar.jobtracker.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
