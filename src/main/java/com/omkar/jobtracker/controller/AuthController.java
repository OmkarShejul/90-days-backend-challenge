package com.omkar.jobtracker.controller;

import org.springframework.security.authentication.*;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.omkar.jobtracker.dto.AuthResponse;
import com.omkar.jobtracker.dto.LoginRequestDto;
import com.omkar.jobtracker.security.CustomUserDetails;
import com.omkar.jobtracker.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public AuthResponse login(@RequestBody LoginRequestDto request) {

        Authentication authentication =
                authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            request.getEmail(),
                            request.getPassword()
                    )
                );

        // 🔥 GET ROLE FROM DB
        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        String role = userDetails.getRole();

        String token = jwtUtil.generateToken(
                request.getEmail(),
                role
        );

        return new AuthResponse(token);
    }

}
