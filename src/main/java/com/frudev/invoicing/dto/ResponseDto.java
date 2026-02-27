package com.frudev.invoicing.dto;

public record ResponseDto<T>(T data, String message) {
    public ResponseDto() {
        this(null, null);
    }

    public ResponseDto(T data) {
        this(data, null);
    }
}
