package com.omkar.jobtracker.service.impl;

import org.springframework.stereotype.Service;
import java.util.List;

import com.omkar.jobtracker.entity.User;
import com.omkar.jobtracker.repository.UserRepository;
import com.omkar.jobtracker.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
