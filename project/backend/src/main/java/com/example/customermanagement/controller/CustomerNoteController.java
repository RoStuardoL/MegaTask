package com.example.customermanagement.controller;

import com.example.customermanagement.dto.CustomerNoteDTO;
import com.example.customermanagement.dto.CustomerNoteRequest;
import com.example.customermanagement.service.CustomerNoteService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customers/{customerId}/notes")
@RequiredArgsConstructor
@SecurityRequirement(name = "bearerAuth")
@Tag(name = "Customer Notes", description = "Customer notes management endpoints")
public class CustomerNoteController {
    private final CustomerNoteService noteService;

    @GetMapping
    @Operation(summary = "Get all notes for a customer")
    public ResponseEntity<List<CustomerNoteDTO>> getNotesByCustomerId(
        @PathVariable String customerId
    ) {
        return ResponseEntity.ok(noteService.getNotesByCustomerId(customerId)
            .stream()
            .map(CustomerNoteDTO::fromNote)
            .toList());
    }

    @PostMapping
    @Operation(summary = "Create new note for a customer")
    public ResponseEntity<CustomerNoteDTO> createNote(
        @PathVariable String customerId,
        @Valid @RequestBody CustomerNoteRequest request
    ) {
        return ResponseEntity.ok(CustomerNoteDTO.fromNote(
            noteService.createNote(request.toNote(customerId))
        ));
    }

    @DeleteMapping("/{noteId}")
    @Operation(summary = "Delete customer note")
    public ResponseEntity<Void> deleteNote(
        @PathVariable String customerId,
        @PathVariable String noteId
    ) {
        noteService.deleteNote(noteId);
        return ResponseEntity.noContent().build();
    }
}