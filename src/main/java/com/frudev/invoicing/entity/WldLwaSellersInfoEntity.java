package com.frudev.invoicing.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "wld_lwa_sellers_info")
public class WldLwaSellersInfoEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sellerInfo_autoid")
    private Long sellerInfoAutoid;

    @Column(name = "auction_id", nullable = false)
    private Integer auctionId;

    @Column(name = "seller_id", nullable = false)
    private Integer sellerId;

    @Column(name = "seller_name", length = 200, nullable = false)
    private String sellerName;

    @Column(name = "company_name", length = 200, nullable = false)
    private String companyName;

    @Column(name = "email", length = 200, nullable = false)
    private String email;

    @Column(name = "contact", nullable = false, columnDefinition = "TEXT")
    private String contact;

    @Column(name = "seller_logo", nullable = false, columnDefinition = "TEXT")
    private String sellerLogo;

    @Column(name = "commission", nullable = false)
    private Float commission;

    @Column(name = "createdon", nullable = false)
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
