package com.example.customermanagement.dto;

import com.example.customermanagement.model.Customer;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerCreateRequest {
    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid email format")
    private String email;

    private String phone;
    private String address;

    public Customer toCustomer() {
        Customer customer = new Customer();
        customer.setName(this.name);
        customer.setEmail(this.email);
        customer.setPhone(this.phone);
        customer.setAddress(this.address);
        return customer;
    }
}