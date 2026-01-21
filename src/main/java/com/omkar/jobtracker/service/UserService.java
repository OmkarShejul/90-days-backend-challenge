package com.omkar.jobtracker.service;

import org.springframework.data.domain.Page;

import com.omkar.jobtracker.dto.UserRequestDto;
import com.omkar.jobtracker.dto.UserResponseDto;

public interface UserService {

    Page<UserResponseDto> getAllUsers(int page, int size, String sortBy);

    Page<UserResponseDto> searchUsersByName(String name, int page, int size);

    UserResponseDto getUserByEmail(String email);

	UserResponseDto createUser(UserRequestDto request);
}
