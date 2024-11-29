package com.example.customermanagement.service;

import com.example.customermanagement.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.List;
import java.util.Optional;

public interface UserService extends UserDetailsService {
    User createUser(User user);
    User updateUser(String id, User user);
    void deleteUser(String id);
    Optional<User> getUserById(String id);
    Optional<User> getUserByEmail(String email);
    List<User> getAllUsers();
    boolean existsByEmail(String email);
}