package com.example.customermanagement.controller;

import com.example.customermanagement.dto.CustomerInteractionDTO;
import com.example.customermanagement.dto.CustomerInteractionRequest;
import com.example.customermanagement.model.InteractionType;
import com.example.customermanagement.service.CustomerInteractionService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/customers/{customerId}/interactions")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Customer Interactions", description = "Customer interactions management endpoints")
public class CustomerInteractionController {
    private final CustomerInteractionService interactionService;

    @GetMapping
    @Operation(summary = "Get all interactions for a customer")
    public ResponseEntity<List<CustomerInteractionDTO>> getInteractionsByCustomerId(
        @PathVariable String customerId,
        @RequestParam(required = false) InteractionType type,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
        @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end
    ) {
        List<CustomerInteractionDTO> interactions;
        if (type != null) {
            interactions = interactionService.getInteractionsByType(type)
                .stream()
                .map(CustomerInteractionDTO::fromInteraction)
                .toList();
        } else if (start != null && end != null) {
            interactions = interactionService.getInteractionsByDateRange(start, end)
                .stream()
                .map(CustomerInteractionDTO::fromInteraction)
                .toList();
        } else {
            interactions = interactionService.getInteractionsByCustomerId(customerId)
                .stream()
                .map(CustomerInteractionDTO::fromInteraction)
                .toList();
        }
        return ResponseEntity.ok(interactions);
    }

    @PostMapping
    @Operation(summary = "Create new interaction for a customer")
    public ResponseEntity<CustomerInteractionDTO> createInteraction(
        @PathVariable String customerId,
        @Valid @RequestBody CustomerInteractionRequest request
    ) {
        return ResponseEntity.ok(CustomerInteractionDTO.fromInteraction(
            interactionService.createInteraction(request.toInteraction(customerId))
        ));
    }

    @DeleteMapping("/{interactionId}")
    @Operation(summary = "Delete customer interaction")
    public ResponseEntity<Void> deleteInteraction(
        @PathVariable String customerId,
        @PathVariable String interactionId
    ) {
        interactionService.deleteInteraction(interactionId);
        return ResponseEntity.noContent().build();
    }
}