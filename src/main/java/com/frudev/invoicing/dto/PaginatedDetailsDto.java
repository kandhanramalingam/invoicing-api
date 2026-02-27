package com.frudev.invoicing.dto;

import java.util.List;

public record PaginatedDetailsDto<T>(
        Integer page,
        Integer perPage,
        Integer totalPages,
        Long totalRecords,
        List<T> records
) {}
