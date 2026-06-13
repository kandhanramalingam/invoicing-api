package com.frudev.invoicing.controller;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.ResponseDto;
import com.frudev.invoicing.service.AuctionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auctions")
public class AuctionController {

    private static final Logger logger = LoggerFactory.getLogger(AuctionController.class);
    private final AuctionService auctionService;

    public AuctionController(AuctionService auctionService) {
        this.auctionService = auctionService;
    }

    @GetMapping
    public ResponseEntity<ResponseDto<PaginatedDetailsDto<?>>> getAll(
            @RequestParam(required = false) String search,
            @RequestParam(defaultValue = "false") boolean lessDetails,
            Pageable pageable) {
        try {
            PaginatedDetailsDto<?> auctions = auctionService.getAll(search, lessDetails, pageable);
            return ResponseEntity.ok(new ResponseDto<>(auctions, "Auctions fetched successfully"));
        } catch (Exception e) {
            logger.error("getAll auctions: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ResponseDto<>(null, e.getMessage()));
        }
    }
}
