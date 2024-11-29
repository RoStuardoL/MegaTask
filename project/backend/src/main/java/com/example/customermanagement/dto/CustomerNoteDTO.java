package com.example.customermanagement.dto;

import com.example.customermanagement.model.CustomerNote;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class CustomerNoteDTO {
    private String id;
    private String customerId;
    private UserDTO user;
    private String note;
    private LocalDateTime createdAt;

    public static CustomerNoteDTO fromNote(CustomerNote note) {
        return CustomerNoteDTO.builder()
            .id(note.getId())
            .customerId(note.getCustomer().getId())
            .user(UserDTO.fromUser(note.getUser()))
            .note(note.getNote())
            .createdAt(note.getCreatedAt())
            .build();
    }
}