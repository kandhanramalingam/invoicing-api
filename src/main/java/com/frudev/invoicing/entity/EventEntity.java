package com.frudev.invoicing.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "wld_inv_events")
public class EventEntity extends Auditable {
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auction_id")
    private AuctionEntity auction;

    @Column(name = "description")
    private String description;

    @Column(name = "location")
    private String location;

    @Column(name = "type")
    private String type;

    @Column(name = "status")
    private String status;

    @Column(name = "deposit_amount")
    private BigDecimal depositAmount;

    @Column(name = "seller")
    private BigDecimal seller;

    @Column(name = "seller_commission_type")
    private Boolean sellerCommissionType;

    @Column(name = "seller_auction_fee")
    private BigDecimal sellerAuctionFee;

    @Column(name = "seller_event_fee")
    private BigDecimal sellerEventFee;

    @Column(name = "seller_club_fee")
    private BigDecimal sellerClubFee;

    @Column(name = "seller_veterinary_fee")
    private BigDecimal sellerVeterinaryFee;

    @Column(name = "seller_marketing_fee")
    private BigDecimal sellerMarketingFee;

    @Column(name = "buyer")
    private BigDecimal buyer;

    @Column(name = "buyer_commission_type")
    private Boolean buyerCommissionType;

    @Column(name = "buyer_auction_fee")
    private BigDecimal buyerAuctionFee;

    @Column(name = "buyer_event_fee")
    private BigDecimal buyerEventFee;

    @Column(name = "buyer_club_fee")
    private BigDecimal buyerClubFee;

    @Column(name = "buyer_veterinary_fee")
    private BigDecimal buyerVeterinaryFee;

    @Column(name = "buyer_marketing_fee")
    private BigDecimal buyerMarketingFee;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public AuctionEntity getAuction() {
        return auction;
    }

    public void setAuction(AuctionEntity auction) {
        this.auction = auction;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
