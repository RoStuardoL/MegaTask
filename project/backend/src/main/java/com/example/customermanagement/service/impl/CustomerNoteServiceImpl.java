package com.example.customermanagement.service.impl;

import com.example.customermanagement.model.CustomerNote;
import com.example.customermanagement.repository.CustomerNoteRepository;
import com.example.customermanagement.service.CustomerNoteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class CustomerNoteServiceImpl implements CustomerNoteService {
    private final CustomerNoteRepository customerNoteRepository;

    @Override
    public CustomerNote createNote(CustomerNote note) {
        return customerNoteRepository.save(note);
    }

    @Override
    public void deleteNote(String id) {
        customerNoteRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<CustomerNote> getNoteById(String id) {
        return customerNoteRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerNote> getNotesByCustomerId(String customerId) {
        return customerNoteRepository.findByCustomerId(customerId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CustomerNote> getNotesByUserId(String userId) {
        return customerNoteRepository.findByUserId(userId);
    }
}