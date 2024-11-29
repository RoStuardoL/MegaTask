package com.example.customermanagement.service.impl;

import com.example.customermanagement.model.AuditLog;
import com.example.customermanagement.repository.AuditLogRepository;
import com.example.customermanagement.service.AuditLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditLogServiceImpl implements AuditLogService {
    private final AuditLogRepository auditLogRepository;

    @Override
    @Transactional
    public AuditLog createLog(String action, String details, String userId) {
        AuditLog log = new AuditLog();
        log.setAction(action);
        log.setDetails(details);
        log.setUserId(userId);
        log.setTimestamp(LocalDateTime.now());
        return auditLogRepository.save(log);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuditLog> getLogsByDateRange(LocalDateTime start, LocalDateTime end) {
        return auditLogRepository.findByTimestampBetween(start, end);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuditLog> getLogsByUser(String userId) {
        return auditLogRepository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<AuditLog> getLogsByAction(String action) {
        return auditLogRepository.findByAction(action);
    }
}