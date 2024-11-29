package com.example.customermanagement.controller;

import com.example.customermanagement.dto.CustomerDTO;
import com.example.customermanagement.dto.CustomerCreateRequest;
import com.example.customermanagement.dto.CustomerUpdateRequest;
import com.example.customermanagement.model.CustomerStatus;
import com.example.customermanagement.service.CustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Customers", description = "Customer management endpoints")
public class CustomerController {
    private final CustomerService customerService;

    @GetMapping
    @Operation(summary = "Get all customers")
    public ResponseEntity<List<CustomerDTO>> getAllCustomers(
        @RequestParam(required = false) CustomerStatus status
    ) {
        List<CustomerDTO> customers = status != null ?
            customerService.getCustomersByStatus(status).stream().map(CustomerDTO::fromCustomer).toList() :
            customerService.getAllCustomers().stream().map(CustomerDTO::fromCustomer).toList();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get customer by ID")
    public ResponseEntity<CustomerDTO> getCustomerById(@PathVariable String id) {
        return customerService.getCustomerById(id)
            .map(CustomerDTO::fromCustomer)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create new customer")
    public ResponseEntity<CustomerDTO> createCustomer(
        @Valid @RequestBody CustomerCreateRequest request
    ) {
        return ResponseEntity.ok(CustomerDTO.fromCustomer(
            customerService.createCustomer(request.toCustomer())
        ));
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update customer")
    public ResponseEntity<CustomerDTO> updateCustomer(
        @PathVariable String id,
        @Valid @RequestBody CustomerUpdateRequest request
    ) {
        return ResponseEntity.ok(CustomerDTO.fromCustomer(
            customerService.updateCustomer(id, request.toCustomer())
        ));
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Delete customer")
    public ResponseEntity<Void> deleteCustomer(@PathVariable String id) {
        customerService.deleteCustomer(id);
        return ResponseEntity.noContent().build();
    }
}