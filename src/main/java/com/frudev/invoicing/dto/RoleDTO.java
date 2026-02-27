package com.frudev.invoicing.dto;

import java.time.LocalDateTime;
import java.util.Set;
import java.util.UUID;

public record RoleDTO(
        UUID id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String createdBy,
        String updatedBy,
        Set<PermissionDTO> permissions
) {
}
