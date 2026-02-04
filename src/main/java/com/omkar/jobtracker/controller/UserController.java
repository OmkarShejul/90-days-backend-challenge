package com.omkar.jobtracker.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import com.omkar.jobtracker.dto.ApiResponse;
import com.omkar.jobtracker.dto.UserRequestDto;
import com.omkar.jobtracker.dto.UserResponseDto;
import com.omkar.jobtracker.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ CREATE USER (PUBLIC)
    @PostMapping
    public ApiResponse<UserResponseDto> createUser(
            @RequestBody UserRequestDto request) {

        return new ApiResponse<>(
                true,
                "User created successfully",
                userService.createUser(request)
        );
    }

    // 🔒 GET ALL USERS (JWT)
    @GetMapping
    public ApiResponse<Page<UserResponseDto>> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return new ApiResponse<>(
                true,
                "Users fetched successfully",
                userService.getAllUsers(page, size, sortBy)
        );
    }

    // 🔒 SEARCH BY NAME
    @GetMapping("/search")
    public ApiResponse<Page<UserResponseDto>> searchUsers(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return new ApiResponse<>(
                true,
                "Users searched successfully",
                userService.searchUsersByName(name, page, size)
        );
    }

    // 🔒 SEARCH BY EMAIL
    @GetMapping("/search/email")
    public ApiResponse<UserResponseDto> getUserByEmail(
            @RequestParam String email
    ) {
        return new ApiResponse<>(
                true,
                "User fetched successfully",
                userService.getUserByEmail(email)
        );
    }
}
