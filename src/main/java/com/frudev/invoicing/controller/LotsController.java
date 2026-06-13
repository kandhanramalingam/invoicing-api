package com.frudev.invoicing.controller;

import com.frudev.invoicing.dto.GroupedLotDto;
import com.frudev.invoicing.dto.GroupedSellerLotDto;
import com.frudev.invoicing.dto.LotDetailDto;
import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.ResponseDto;
import com.frudev.invoicing.service.LotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/lots")
public class LotsController {

    @Autowired
    private LotService lotService;

    @GetMapping("/auctions/{auctionId}")
    public ResponseEntity<ResponseDto<PaginatedDetailsDto<LotDetailDto>>> getLotsByAuctionId(
            @PathVariable Integer auctionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        PaginatedDetailsDto<LotDetailDto> lotDetails = lotService.getLotDetailsByAuctionId(auctionId, pageable);
        
        return ResponseEntity.ok(new ResponseDto<>(lotDetails, "Lots fetched successfully"));
    }

    @GetMapping("/auctions/{auctionId}/groupByBuyer")
    public ResponseEntity<ResponseDto<List<GroupedLotDto>>> getLotsGroupByBuyerByAuctionId(
            @PathVariable Integer auctionId) {
        
        List<GroupedLotDto> groupedLots = lotService.getLotDetailsGroupByBuyerByAuctionId(auctionId);
        
        return ResponseEntity.ok(new ResponseDto<>(groupedLots, "Lots grouped by buyer fetched successfully"));
    }

    @GetMapping("/auctions/{auctionId}/groupBySeller")
    public ResponseEntity<ResponseDto<List<GroupedSellerLotDto>>> getLotsGroupBySellerByAuctionId(
            @PathVariable Integer auctionId) {

        List<GroupedSellerLotDto> groupedLots = lotService.getLotDetailsGroupBySellerByAuctionId(auctionId);

        return ResponseEntity.ok(new ResponseDto<>(groupedLots, "Lots grouped by seller fetched successfully"));
    }
}
