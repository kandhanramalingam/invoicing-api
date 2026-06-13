package com.frudev.invoicing.entity;

import jakarta.persistence.PostPersist;
import jakarta.persistence.PostRemove;
import jakarta.persistence.PostUpdate;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.UUID;

@Component
public class AuditTableListener {

    private static ObjectProvider<JdbcTemplate> jdbcTemplateProvider;

    @Autowired
    public void setJdbcTemplateProvider(ObjectProvider<JdbcTemplate> jdbcTemplateProvider) {
        AuditTableListener.jdbcTemplateProvider = jdbcTemplateProvider;
    }

    @PostPersist
    public void onPostPersist(Object entity) {
        logAudit(entity, "CREATE");
    }

    @PostUpdate
    public void onPostUpdate(Object entity) {
        logAudit(entity, "UPDATE");
    }

    @PostRemove
    public void onPostRemove(Object entity) {
        logAudit(entity, "DELETE");
    }

    private void logAudit(Object entity, String action) {
        if (entity instanceof AuditEntity) {
            return;
        }

        JdbcTemplate jdbcTemplate = jdbcTemplateProvider.getIfAvailable();
        if (jdbcTemplate == null) {
            return;
        }

        try {
            String entityName = entity.getClass().getSimpleName();
            String username = SecurityContextHolder.getContext().getAuthentication() != null 
                    ? SecurityContextHolder.getContext().getAuthentication().getName() 
                    : "SYSTEM";
            
            // Note: This is a simplified audit logging. 
            // In a real scenario, you'd want to capture oldValue/newValue using reflection or Hibernate Interceptors.
            jdbcTemplate.update(
                "INSERT INTO wld_inv_audit_logs (ID, ENTITY_NAME, ACTION, USER_NAME, CREATED_AT) VALUES (?, ?, ?, ?, ?)",
                UUID.randomUUID(), entityName, action, username, LocalDateTime.now()
            );
        } catch (Exception e) {
            // Log error but don't fail the transaction
            System.err.println("Failed to log audit: " + e.getMessage());
        }
    }
}
