package com.example.customermanagement.dto;

import com.example.customermanagement.model.CustomerNote;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CustomerNoteRequest {
    @NotBlank(message = "Note content is required")
    private String note;

    public CustomerNote toNote(String customerId) {
        CustomerNote customerNote = new CustomerNote();
        customerNote.setNote(this.note);
        return customerNote;
    }
}