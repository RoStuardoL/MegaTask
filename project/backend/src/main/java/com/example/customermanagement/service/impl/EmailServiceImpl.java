package com.example.customermanagement.service.impl;

import com.example.customermanagement.dto.EmailRequest;
import com.example.customermanagement.service.EmailService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;

    @Value("${spring.mail.from}")
    private String fromEmail;

    @Override
    public void sendEmail(EmailRequest emailRequest) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(emailRequest.getTo());
        message.setSubject(emailRequest.getSubject());
        message.setText(emailRequest.getBody());
        mailSender.send(message);
    }

    @Override
    public void sendWelcomeEmail(String to, String name) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject("Welcome to Customer Management System");
        message.setText(String.format(
            "Dear %s,\n\nWelcome to our Customer Management System! " +
            "We're excited to have you on board.\n\n" +
            "Best regards,\nThe CMS Team", name));
        mailSender.send(message);
    }

    @Override
    public void sendPasswordResetEmail(String to, String resetToken) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject("Password Reset Request");
        message.setText(String.format(
            "Hello,\n\nYou have requested to reset your password. " +
            "Please use the following token to reset your password: %s\n\n" +
            "If you didn't request this, please ignore this email.\n\n" +
            "Best regards,\nThe CMS Team", resetToken));
        mailSender.send(message);
    }

    @Override
    public void sendCustomerUpdateNotification(String to, String customerName, String updateType) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(fromEmail);
        message.setTo(to);
        message.setSubject("Customer Update Notification");
        message.setText(String.format(
            "Hello,\n\nThis is to notify you that customer %s has been %s.\n\n" +
            "Best regards,\nThe CMS Team", customerName, updateType));
        mailSender.send(message);
    }
}