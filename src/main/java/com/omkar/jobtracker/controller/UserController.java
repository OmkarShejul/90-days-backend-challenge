package com.omkar.jobtracker.controller;

import com.omkar.jobtracker.dto.UserRequestDto;
import com.omkar.jobtracker.dto.UserResponseDto;
import com.omkar.jobtracker.entity.User;
import com.omkar.jobtracker.service.UserService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // CREATE USER (already done)
    @PostMapping
    public UserResponseDto createUser(
            @Valid @RequestBody UserRequestDto dto) {

        User user = new User();
        user.setName(dto.getName());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());

        User savedUser = userService.createUser(user);

        return mapToResponse(savedUser);
    }

    // ✅ GET ALL USERS
    @GetMapping
    public List<UserResponseDto> getAllUsers() {
        return userService.getAllUsers()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // ✅ GET USER BY ID
    @GetMapping("/{id}")
    public UserResponseDto getUserById(@PathVariable Long id) {
        return mapToResponse(userService.getUserById(id));
    }

    // 🔁 COMMON MAPPING METHOD
    private UserResponseDto mapToResponse(User user) {
        UserResponseDto dto = new UserResponseDto();
        dto.setId(user.getId());
        dto.setName(user.getName());
        dto.setEmail(user.getEmail());
        return dto;
    }
}
