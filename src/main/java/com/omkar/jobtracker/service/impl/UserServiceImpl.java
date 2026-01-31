package com.omkar.jobtracker.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.*;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.omkar.jobtracker.dto.UserRequestDto;
import com.omkar.jobtracker.dto.UserResponseDto;
import com.omkar.jobtracker.entity.User;
import com.omkar.jobtracker.exception.ResourceNotFoundException;
import com.omkar.jobtracker.repository.UserRepository;
import com.omkar.jobtracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private static final Logger log = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
public UserResponseDto createUser(UserRequestDto request) {

    log.info("Creating new user with email: {}", request.getEmail());

    User user = new User();
    user.setName(request.getName());
    user.setEmail(request.getEmail());
    user.setPassword(passwordEncoder.encode(request.getPassword()));
    user.setRole("USER");

    User savedUser = userRepository.save(user);

    log.info("User created successfully with ID: {}", savedUser.getId());

    return new UserResponseDto(
            savedUser.getId(),
            savedUser.getName(),
            savedUser.getEmail()
    );
}

    @Override
    public Page<UserResponseDto> getAllUsers(int page, int size, String sortBy) {

        Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy));

        return userRepository.findAll(pageable)
                .map(u -> new UserResponseDto(
                        u.getId(),
                        u.getName(),
                        u.getEmail()
                ));
    }

    @Override
    public Page<UserResponseDto> searchUsersByName(String name, int page, int size) {

        Pageable pageable = PageRequest.of(page, size);

        return userRepository.findByNameContainingIgnoreCase(name, pageable)
                .map(u -> new UserResponseDto(
                        u.getId(),
                        u.getName(),
                        u.getEmail()
                ));
    }

    @Override
    public UserResponseDto getUserByEmail(String email) {

        User user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "User not found with email: " + email));

        return new UserResponseDto(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
