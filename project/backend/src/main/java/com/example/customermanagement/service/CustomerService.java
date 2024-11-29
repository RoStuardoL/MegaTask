package com.example.customermanagement.service;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.model.CustomerStatus;
import java.util.List;
import java.util.Optional;

public interface CustomerService {
    Customer createCustomer(Customer customer);
    Customer updateCustomer(String id, Customer customer);
    void deleteCustomer(String id);
    Optional<Customer> getCustomerById(String id);
    List<Customer> getAllCustomers();
    List<Customer> getCustomersByStatus(CustomerStatus status);
    List<Customer> getCustomersByCreatedBy(String userId);
    boolean existsByEmail(String email);
}