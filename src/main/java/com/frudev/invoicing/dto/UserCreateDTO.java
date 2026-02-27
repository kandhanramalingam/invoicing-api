package com.frudev.invoicing.dto;

import java.util.Set;
import java.util.UUID;

public record UserCreateDTO(
    String email,
    String fullName,
    Integer active,
    Set<UUID> roleIds
) {}
