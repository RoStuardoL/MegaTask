package com.example.customermanagement.service;

import com.example.customermanagement.model.AuditLog;
import java.time.LocalDateTime;
import java.util.List;

public interface AuditLogService {
    AuditLog createLog(String action, String details, String userId);
    List<AuditLog> getLogsByDateRange(LocalDateTime start, LocalDateTime end);
    List<AuditLog> getLogsByUser(String userId);
    List<AuditLog> getLogsByAction(String action);
}