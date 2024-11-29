package com.example.customermanagement.dto;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.model.CustomerStatus;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Data
public class CustomerUpdateRequest {
    private String name;

    @Email(message = "Invalid email format")
    private String email;

    private String phone;
    private String address;
    private CustomerStatus status;

    public Customer toCustomer() {
        Customer customer = new Customer();
        customer.setName(this.name);
        customer.setEmail(this.email);
        customer.setPhone(this.phone);
        customer.setAddress(this.address);
        customer.setStatus(this.status);
        return customer;
    }
}