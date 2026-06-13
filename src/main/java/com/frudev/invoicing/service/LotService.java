package com.frudev.invoicing.service;

import com.frudev.invoicing.dto.GroupedLotDto;
import com.frudev.invoicing.dto.GroupedSellerLotDto;
import com.frudev.invoicing.dto.LotDetailDto;
import com.frudev.invoicing.dto.PaginatedDetailsDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface LotService {
    PaginatedDetailsDto<LotDetailDto> getLotDetailsByAuctionId(Integer auctionId, Pageable pageable);

    List<GroupedLotDto> getLotDetailsGroupByBuyerByAuctionId(Integer auctionId);
    
    List<GroupedSellerLotDto> getLotDetailsGroupBySellerByAuctionId(Integer auctionId);
}
