package com.omkar.jobtracker.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.jobtracker.dto.UserResponseDto;
import com.omkar.jobtracker.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // ✅ MANUAL CONSTRUCTOR (FIXES THE ERROR)
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // PAGINATION + SORTING
    @GetMapping
    public Page<UserResponseDto> getAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return userService.getAllUsers(page, size, sortBy);
    }

    // SEARCH BY NAME
    @GetMapping("/search")
    public Page<UserResponseDto> searchUsers(
            @RequestParam String name,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size
    ) {
        return userService.searchUsersByName(name, page, size);
    }

    // SEARCH BY EMAIL
    @GetMapping("/search/email")
    public UserResponseDto getUserByEmail(@RequestParam String email) {
        return userService.getUserByEmail(email);
    }
}
