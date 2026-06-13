package com.frudev.invoicing.service;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import org.springframework.data.domain.Pageable;

public interface AuctionService {
    PaginatedDetailsDto<?> getAll(String search, boolean lessDetails, Pageable pageable);
}
