package com.omkar.jobtracker.dto;

public class AuthResponse {

    private String token;
    private String email;
    private String role;

    // ✅ REQUIRED CONSTRUCTOR (THIS FIXES YOUR ERROR)
    public AuthResponse(String token, String email, String role) {
        this.token = token;
        this.email = email;
        this.role = role;
    }

    // ✅ Getters
    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }
}
