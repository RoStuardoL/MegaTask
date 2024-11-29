package com.example.customermanagement.service.impl;

import com.example.customermanagement.model.Customer;
import com.example.customermanagement.model.CustomerStatus;
import com.example.customermanagement.repository.CustomerRepository;
import com.example.customermanagement.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public Customer createCustomer(Customer customer) {
        if (customerRepository.existsByEmail(customer.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(String id, Customer customer) {
        Customer existingCustomer = customerRepository.findById(id)
            .orElseThrow(() -> new IllegalArgumentException("Customer not found"));
        
        if (!existingCustomer.getEmail().equals(customer.getEmail()) && 
            customerRepository.existsByEmail(customer.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }
        
        existingCustomer.setName(customer.getName());
        existingCustomer.setEmail(customer.getEmail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setAddress(customer.getAddress());
        existingCustomer.setStatus(customer.getStatus());
        
        return customerRepository.save(existingCustomer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Customer> getCustomerById(String id) {
        return customerRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getCustomersByStatus(CustomerStatus status) {
        return customerRepository.findByStatus(status);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Customer> getCustomersByCreatedBy(String userId) {
        return customerRepository.findByCreatedById(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean existsByEmail(String email) {
        return customerRepository.existsByEmail(email);
    }
}