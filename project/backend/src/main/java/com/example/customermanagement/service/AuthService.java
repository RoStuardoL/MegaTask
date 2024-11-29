package com.example.customermanagement.service;

import com.example.customermanagement.dto.AuthRequest;
import com.example.customermanagement.dto.AuthResponse;
import com.example.customermanagement.dto.RegisterRequest;

public interface AuthService {
    AuthResponse login(AuthRequest request);
    AuthResponse register(RegisterRequest request);
}