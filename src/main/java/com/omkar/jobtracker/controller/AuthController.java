package com.omkar.jobtracker.controller;

import com.omkar.jobtracker.dto.LoginRequestDto;
import com.omkar.jobtracker.dto.LoginResponseDto;
import com.omkar.jobtracker.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDto> login(@RequestBody LoginRequestDto request) {

        // TEMP hardcoded user (Day 10 me DB se hoga)
        if (!request.getEmail().equals("test@gmail.com") ||
            !request.getPassword().equals("12345")) {

            return ResponseEntity.status(401).build();
        }

        String token = JwtUtil.generateToken(request.getEmail());
        return ResponseEntity.ok(new LoginResponseDto(token));
    }
}
