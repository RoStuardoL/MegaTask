package com.example.customermanagement.service.impl;

import com.example.customermanagement.model.CustomerInteraction;
import com.example.customermanagement.model.InteractionType;
import com.example.customermanagement.repository.CustomerInteractionRepository;
import com.example.customermanagement.service.CustomerInteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerInteractionServiceImpl implements CustomerInteractionService {
    private final CustomerInteractionRepository interactionRepository;

    @Override
    public CustomerInteraction createInteraction(CustomerInteraction interaction) {
        return interactionRepository.save(interaction);
    }

    @Override
    public void deleteInteraction(String id) {
        interactionRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerInteraction> getInteractionById(String id) {
        return interactionRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerInteraction> getInteractionsByCustomerId(String customerId) {
        return interactionRepository.findByCustomerId(customerId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerInteraction> getInteractionsByUserId(String userId) {
        return interactionRepository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerInteraction> getInteractionsByType(InteractionType type) {
        return interactionRepository.findByType(type);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerInteraction> getInteractionsByDateRange(LocalDateTime start, LocalDateTime end) {
        return interactionRepository.findByInteractionDateBetween(start, end);
    }
}