package com.example.customermanagement.service;

import com.example.customermanagement.dto.EmailRequest;

public interface EmailService {
    void sendEmail(EmailRequest emailRequest);
    void sendWelcomeEmail(String to, String name);
    void sendPasswordResetEmail(String to, String resetToken);
    void sendCustomerUpdateNotification(String to, String customerName, String updateType);
}