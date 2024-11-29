package com.example.customermanagement.dto;

import com.example.customermanagement.model.CustomerInteraction;
import com.example.customermanagement.model.InteractionType;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CustomerInteractionRequest {
    @NotNull(message = "Interaction type is required")
    private InteractionType type;

    private String description;

    @NotNull(message = "Interaction date is required")
    private LocalDateTime interactionDate;

    public CustomerInteraction toInteraction(String customerId) {
        CustomerInteraction interaction = new CustomerInteraction();
        interaction.setType(this.type);
        interaction.setDescription(this.description);
        interaction.setInteractionDate(this.interactionDate);
        return interaction;
    }
}