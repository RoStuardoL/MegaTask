package com.example.customermanagement.service.impl;

import com.example.customermanagement.dto.AuthRequest;
import com.example.customermanagement.dto.AuthResponse;
import com.example.customermanagement.dto.RegisterRequest;
import com.example.customermanagement.dto.UserDTO;
import com.example.customermanagement.model.User;
import com.example.customermanagement.model.UserRole;
import com.example.customermanagement.service.AuthService;
import com.example.customermanagement.service.JwtService;
import com.example.customermanagement.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserService userService;
    private final JwtService jwtService;

    @Override
    @Transactional
    public AuthResponse login(AuthRequest request) {
        Authentication authentication = authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        User user = userService.getUserByEmail(request.getEmail())
            .orElseThrow(() -> new IllegalStateException("User not found"));

        String token = jwtService.generateToken(user);
        return AuthResponse.builder()
            .token(token)
            .user(UserDTO.fromUser(user))
            .build();
    }

    @Override
    @Transactional
    public AuthResponse register(RegisterRequest request) {
        if (userService.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User user = new User();
        user.setEmail(request.getEmail());
        user.setName(request.getName());
        user.setPasswordHash(request.getPassword());
        user.setRole(UserRole.USER);

        User savedUser = userService.createUser(user);
        String token = jwtService.generateToken(savedUser);

        return AuthResponse.builder()
            .token(token)
            .user(UserDTO.fromUser(savedUser))
            .build();
    }
}