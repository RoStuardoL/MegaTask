package com.example.customermanagement.service;

import com.example.customermanagement.model.CustomerInteraction;
import com.example.customermanagement.model.InteractionType;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface CustomerInteractionService {
    CustomerInteraction createInteraction(CustomerInteraction interaction);
    void deleteInteraction(String id);
    Optional<CustomerInteraction> getInteractionById(String id);
    List<CustomerInteraction> getInteractionsByCustomerId(String customerId);
    List<CustomerInteraction> getInteractionsByUserId(String userId);
    List<CustomerInteraction> getInteractionsByType(InteractionType type);
    List<CustomerInteraction> getInteractionsByDateRange(LocalDateTime start, LocalDateTime end);
}