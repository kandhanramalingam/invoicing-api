package com.frudev.invoicing.dto;

public record PasswordUpdateDTO(
    String currentPassword,
    String newPassword
) {}
