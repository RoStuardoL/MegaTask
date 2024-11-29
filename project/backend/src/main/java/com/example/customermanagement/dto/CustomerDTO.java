package com.example.customermanagement.dto;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.model.CustomerStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CustomerDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String address;
    private CustomerStatus status;
    private UserDTO createdBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static CustomerDTO fromCustomer(Customer customer) {
        return CustomerDTO.builder()
            .id(customer.getId())
            .name(customer.getName())
            .email(customer.getEmail())
            .phone(customer.getPhone())
            .address(customer.getAddress())
            .status(customer.getStatus())
            .createdBy(UserDTO.fromUser(customer.getCreatedBy()))
            .createdAt(customer.getCreatedAt())
            .updatedAt(customer.getUpdatedAt())
            .build();
    }
}