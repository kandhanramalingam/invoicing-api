package com.frudev.invoicing.dto;

import java.time.LocalDate;

public class SellerDto {
    private Long sellerInfoAutoid;
    private Integer auctionId;
    private Integer sellerId;
    private String sellerName;
    private String companyName;
    private String email;
    private String contact;
    private String sellerLogo;
    private Float commission;
    private LocalDate createdOn;

    public Long getSellerInfoAutoid() {
        return sellerInfoAutoid;
    }

    public void setSellerInfoAutoid(Long sellerInfoAutoid) {
        this.sellerInfoAutoid = sellerInfoAutoid;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getSellerLogo() {
        return sellerLogo;
    }

    public void setSellerLogo(String sellerLogo) {
        this.sellerLogo = sellerLogo;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }

    public LocalDate getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDate createdOn) {
        this.createdOn = createdOn;
    }
}
