package com.example.customermanagement.dto;

import com.example.customermanagement.model.CustomerInteraction;
import com.example.customermanagement.model.InteractionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CustomerInteractionDTO {
    private String id;
    private String customerId;
    private UserDTO user;
    private InteractionType type;
    private String description;
    private LocalDateTime interactionDate;
    private LocalDateTime createdAt;

    public static CustomerInteractionDTO fromInteraction(CustomerInteraction interaction) {
        return CustomerInteractionDTO.builder()
            .id(interaction.getId())
            .customerId(interaction.getCustomer().getId())
            .user(UserDTO.fromUser(interaction.getUser()))
            .type(interaction.getType())
            .description(interaction.getDescription())
            .interactionDate(interaction.getInteractionDate())
            .createdAt(interaction.getCreatedAt())
            .build();
    }
}