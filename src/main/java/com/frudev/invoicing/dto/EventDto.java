package com.frudev.invoicing.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventDto(
        String id,
        Long auctionId,
        AuctionSimpleDto auction,
        String description,
        String location,
        String type,
        String status,
        BigDecimal depositAmount,
        BigDecimal seller,
        Boolean sellerCommissionType,
        BigDecimal sellerAuctionFee,
        BigDecimal sellerEventFee,
        BigDecimal sellerClubFee,
        BigDecimal sellerVeterinaryFee,
        BigDecimal sellerMarketingFee,
        BigDecimal buyer,
        Boolean buyerCommissionType,
        BigDecimal buyerAuctionFee,
        BigDecimal buyerEventFee,
        BigDecimal buyerClubFee,
        BigDecimal buyerVeterinaryFee,
        BigDecimal buyerMarketingFee,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        String createdBy,
        String updatedBy
) {}
