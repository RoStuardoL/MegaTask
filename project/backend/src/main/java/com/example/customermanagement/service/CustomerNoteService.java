package com.example.customermanagement.service;

import com.example.customermanagement.model.CustomerNote;
import java.util.List;
import java.util.Optional;

public interface CustomerNoteService {
    CustomerNote createNote(CustomerNote note);
    void deleteNote(String id);
    Optional<CustomerNote> getNoteById(String id);
    List<CustomerNote> getNotesByCustomerId(String customerId);
    List<CustomerNote> getNotesByUserId(String userId);
}