package com.frudev.invoicing.dto;

public record AuctionSimpleDto(
        Long id,
        String nameOfAuction,
        String dateOfAuction,
        String gpsCord1,
        String gpsCord2
) {}
