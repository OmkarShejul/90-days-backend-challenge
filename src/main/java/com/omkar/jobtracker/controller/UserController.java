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

    // ✅ Manual constructor
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ✅ CREATE USER (PUBLIC API)
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto request) {
        return userService.createUser(request);
    }

    // 🔒 GET ALL USERS (JWT REQUIRED)
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
    public Page<UserResponseDto> searchUsers(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return userService.searchUsersByName(name, page, size);
    }

    // 🔒 SEARCH BY EMAIL
    @GetMapping("/search/email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}
