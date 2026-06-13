package com.frudev.invoicing.service;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.SellerDto;
import org.springframework.data.domain.Pageable;

public interface SellerService {
    PaginatedDetailsDto<SellerDto> getSellersByAuctionId(Integer auctionId, Pageable pageable);

    void updateCommission(Long sellerInfoAutoid, Float commission);
}
