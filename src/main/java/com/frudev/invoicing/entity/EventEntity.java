package com.frudev.invoicing.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "EVENTS")
public class EventEntity extends Auditable {
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "DATE")
    private LocalDateTime date;

    @Column(name = "LOCATION")
    private String location;

    @Column(name = "TYPE")
    private String type;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "DEPOSIT_AMOUNT")
    private BigDecimal depositAmount;

    @Column(name = "SELLER")
    private BigDecimal seller;

    @Column(name = "SELLER_COMMISSION_TYPE")
    private Boolean sellerCommissionType;

    @Column(name = "SELLER_AUCTION_FEE")
    private BigDecimal sellerAuctionFee;

    @Column(name = "SELLER_EVENT_FEE")
    private BigDecimal sellerEventFee;

    @Column(name = "SELLER_CLUB_FEE")
    private BigDecimal sellerClubFee;

    @Column(name = "SELLER_VETERINARY_FEE")
    private BigDecimal sellerVeterinaryFee;

    @Column(name = "SELLER_MARKETING_FEE")
    private BigDecimal sellerMarketingFee;

    @Column(name = "BUYER")
    private BigDecimal buyer;

    @Column(name = "BUYER_COMMISSION_TYPE")
    private Boolean buyerCommissionType;

    @Column(name = "BUYER_AUCTION_FEE")
    private BigDecimal buyerAuctionFee;

    @Column(name = "BUYER_EVENT_FEE")
    private BigDecimal buyerEventFee;

    @Column(name = "BUYER_CLUB_FEE")
    private BigDecimal buyerClubFee;

    @Column(name = "BUYER_VETERINARY_FEE")
    private BigDecimal buyerVeterinaryFee;

    @Column(name = "BUYER_MARKETING_FEE")
    private BigDecimal buyerMarketingFee;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getDepositAmount() {
        return depositAmount;
    }

    public void setDepositAmount(BigDecimal depositAmount) {
        this.depositAmount = depositAmount;
    }

    public BigDecimal getSeller() {
        return seller;
    }

    public void setSeller(BigDecimal seller) {
        this.seller = seller;
    }

    public Boolean getSellerCommissionType() {
        return sellerCommissionType;
    }

    public void setSellerCommissionType(Boolean sellerCommissionType) {
        this.sellerCommissionType = sellerCommissionType;
    }

    public BigDecimal getSellerAuctionFee() {
        return sellerAuctionFee;
    }

    public void setSellerAuctionFee(BigDecimal sellerAuctionFee) {
        this.sellerAuctionFee = sellerAuctionFee;
    }

    public BigDecimal getSellerEventFee() {
        return sellerEventFee;
    }

    public void setSellerEventFee(BigDecimal sellerEventFee) {
        this.sellerEventFee = sellerEventFee;
    }

    public BigDecimal getSellerClubFee() {
        return sellerClubFee;
    }

    public void setSellerClubFee(BigDecimal sellerClubFee) {
        this.sellerClubFee = sellerClubFee;
    }

    public BigDecimal getSellerVeterinaryFee() {
        return sellerVeterinaryFee;
    }

    public void setSellerVeterinaryFee(BigDecimal sellerVeterinaryFee) {
        this.sellerVeterinaryFee = sellerVeterinaryFee;
    }

    public BigDecimal getSellerMarketingFee() {
        return sellerMarketingFee;
    }

    public void setSellerMarketingFee(BigDecimal sellerMarketingFee) {
        this.sellerMarketingFee = sellerMarketingFee;
    }

    public BigDecimal getBuyer() {
        return buyer;
    }

    public void setBuyer(BigDecimal buyer) {
        this.buyer = buyer;
    }

    public Boolean getBuyerCommissionType() {
        return buyerCommissionType;
    }

    public void setBuyerCommissionType(Boolean buyerCommissionType) {
        this.buyerCommissionType = buyerCommissionType;
    }

    public BigDecimal getBuyerAuctionFee() {
        return buyerAuctionFee;
    }

    public void setBuyerAuctionFee(BigDecimal buyerAuctionFee) {
        this.buyerAuctionFee = buyerAuctionFee;
    }

    public BigDecimal getBuyerEventFee() {
        return buyerEventFee;
    }

    public void setBuyerEventFee(BigDecimal buyerEventFee) {
        this.buyerEventFee = buyerEventFee;
    }

    public BigDecimal getBuyerClubFee() {
        return buyerClubFee;
    }

    public void setBuyerClubFee(BigDecimal buyerClubFee) {
        this.buyerClubFee = buyerClubFee;
    }

    public BigDecimal getBuyerVeterinaryFee() {
        return buyerVeterinaryFee;
    }

    public void setBuyerVeterinaryFee(BigDecimal buyerVeterinaryFee) {
        this.buyerVeterinaryFee = buyerVeterinaryFee;
    }

    public BigDecimal getBuyerMarketingFee() {
        return buyerMarketingFee;
    }

    public void setBuyerMarketingFee(BigDecimal buyerMarketingFee) {
        this.buyerMarketingFee = buyerMarketingFee;
    }
}
