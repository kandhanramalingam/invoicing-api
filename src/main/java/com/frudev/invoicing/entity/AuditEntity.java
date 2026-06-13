package com.frudev.invoicing.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "wld_inv_audit_logs")
public class AuditEntity {

    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "ENTITY_NAME")
    private String entityName;

    @Column(name = "ENTITY_ID")
    private String entityId;

    @Column(name = "ACTION")
    private String action;

    @Column(name = "OLD_VALUE", columnDefinition = "TEXT")
    private String oldValue;

    @Column(name = "NEW_VALUE", columnDefinition = "TEXT")
    private String newValue;

    @Column(name = "USER_NAME")
    private String username;

    @Column(name = "IP_ADDRESS")
    private String ipAddress;

    @Column(name = "REQUEST_ID")
    private String requestId;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt = LocalDateTime.now();

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityId() {
        return entityId;
    }

    public void setEntityId(String entityId) {
        this.entityId = entityId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
