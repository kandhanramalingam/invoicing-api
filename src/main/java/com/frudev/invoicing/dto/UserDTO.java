package com.frudev.invoicing.dto;

import java.time.LocalDateTime;
import java.util.Set;

public record UserDTO(
        String id,
        String email,
        String fullName,
        Integer active,
        Set<RoleDTO> roles,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String createdBy,
        String updatedBy
) {
}
