package com.frudev.invoicing.dto;

import java.util.Set;
import java.util.UUID;

public record RoleCreateDTO(
        String name,
        Set<UUID> permissionIds
) {
}
