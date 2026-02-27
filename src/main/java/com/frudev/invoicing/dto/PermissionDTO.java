package com.frudev.invoicing.dto;

import java.time.LocalDateTime;

public record PermissionDTO(
        String id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String createdBy,
        String updatedBy
) {
}
