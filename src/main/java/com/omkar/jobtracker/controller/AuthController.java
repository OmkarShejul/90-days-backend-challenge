package com.omkar.jobtracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.omkar.jobtracker.dto.ApiResponse;
import com.omkar.jobtracker.dto.AuthResponse;
import com.omkar.jobtracker.dto.LoginRequestDto;
import com.omkar.jobtracker.security.CustomUserDetails;
import com.omkar.jobtracker.security.JwtUtil;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private static final Logger log =
            LoggerFactory.getLogger(AuthController.class);

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(
            AuthenticationManager authenticationManager,
            JwtUtil jwtUtil
    ) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ApiResponse<AuthResponse> login(
            @RequestBody LoginRequestDto request
    ) {

        log.info("Login attempt for email: {}", request.getEmail());

        Authentication authentication =
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(
                                request.getEmail(),
                                request.getPassword()
                        )
                );

        CustomUserDetails userDetails =
                (CustomUserDetails) authentication.getPrincipal();

        String token = jwtUtil.generateToken(
                userDetails.getUsername(),
                userDetails.getRole()
        );

        AuthResponse authResponse =new AuthResponse(token,userDetails.getUsername(),userDetails.getRole());

        log.info("Login successful for email: {}", request.getEmail());

        return new ApiResponse<>(
                true,
                "Login successful",
                authResponse
        );
    }
}
