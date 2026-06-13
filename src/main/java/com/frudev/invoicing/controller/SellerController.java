package com.frudev.invoicing.controller;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.ResponseDto;
import com.frudev.invoicing.dto.SellerDto;
import com.frudev.invoicing.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sellers")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping("/auctions/{auctionId}")
    public ResponseEntity<ResponseDto<PaginatedDetailsDto<SellerDto>>> getSellersByAuctionId(
            @PathVariable Integer auctionId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        
        Pageable pageable = PageRequest.of(page, size);
        PaginatedDetailsDto<SellerDto> sellers = sellerService.getSellersByAuctionId(auctionId, pageable);
        
        return ResponseEntity.ok(new ResponseDto<>(sellers, "Sellers fetched successfully"));
    }

    @PutMapping("/{sellerInfoAutoid}/commission")
    public ResponseEntity<ResponseDto<Void>> updateCommission(
            @PathVariable Long sellerInfoAutoid,
            @RequestParam Float commission) {
        
        sellerService.updateCommission(sellerInfoAutoid, commission);
        return ResponseEntity.ok(new ResponseDto<>(null, "Commission updated successfully"));
    }
}
