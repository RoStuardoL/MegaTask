package com.example.customermanagement.dto;

import com.example.customermanagement.model.User;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class UserUpdateRequest {
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private String password;

    public User toUser() {
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        user.setPasswordHash(this.password); // Will be encoded in service layer
        return user;
    }
}