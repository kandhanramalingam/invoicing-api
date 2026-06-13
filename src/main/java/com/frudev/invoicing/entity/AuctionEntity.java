package com.frudev.invoicing.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wld_admin_jointco_auction")
public class AuctionEntity {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "NameOfAuction", length = 50, nullable = false)
    private String nameOfAuction;

    @Column(name = "DateOfAuction", length = 100, nullable = false)
    private String dateOfAuction;

    @Column(name = "address1", length = 50, nullable = false)
    private String address1;

    @Column(name = "address2", length = 50, nullable = false)
    private String address2;

    @Column(name = "address3", length = 50, nullable = false)
    private String address3;

    @Column(name = "GpsCord1", length = 50, nullable = false)
    private String gpsCord1;

    @Column(name = "GpsCord2", length = 50, nullable = false)
    private String gpsCord2;

    @Column(name = "website", length = 50, nullable = false)
    private String website;

    @Column(name = "aucCategoryName", length = 50, nullable = false)
    private String aucCategoryName;

    @Column(name = "aucCategoryId", nullable = false)
    private Integer aucCategoryId;

    @Column(name = "layout", length = 50, nullable = false)
    private String layout;

    @Column(name = "SellerName", length = 50, nullable = false)
    private String sellerName;

    @Column(name = "AuctioneerName", length = 50, nullable = false)
    private String auctioneerName;

    @Lob
    @Column(name = "logo_name", nullable = false)
    private String logoName;

    @Lob
    @Column(name = "seller_logo", nullable = false)
    private String sellerLogo;

    @Lob
    @Column(name = "map", nullable = false)
    private String map;

    @Lob
    @Column(name = "terms_condition", nullable = false)
    private String termsCondition;

    @Column(name = "applogo", length = 50, nullable = false)
    private String appLogo;

    @Column(name = "sellerhplogo", length = 50, nullable = false)
    private String sellerHpLogo;

    @Lob
    @Column(name = "catalog", nullable = false)
    private String catalog;

    @Lob
    @Column(name = "export_catalogue", nullable = false)
    private String exportCatalogue;

    @Column(name = "open_date", length = 100, nullable = false)
    private String openDate;

    @Column(name = "close_date", length = 100, nullable = false)
    private String closeDate;

    @Column(name = "lockReg", length = 10, nullable = false)
    private String lockReg;

    @Column(name = "created_date", nullable = false)
    private LocalDateTime createdDate;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "remove_status", nullable = false)
    private String removeStatus;

    @Column(name = "archive_status", nullable = false)
    private String archiveStatus;

    @Column(name = "interval", length = 15, nullable = false)
    private String interval;

    @Column(name = "reject_bid", length = 255, nullable = false)
    private String rejectBid;

    @Column(name = "mob_reject_bid", length = 255, nullable = false)
    private String mobRejectBid;

    @Column(name = "transaction", nullable = false)
    private String transaction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameOfAuction() {
        return nameOfAuction;
    }

    public void setNameOfAuction(String nameOfAuction) {
        this.nameOfAuction = nameOfAuction;
    }

    public String getDateOfAuction() {
        return dateOfAuction;
    }

    public void setDateOfAuction(String dateOfAuction) {
        this.dateOfAuction = dateOfAuction;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getAddress3() {
        return address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    public String getGpsCord1() {
        return gpsCord1;
    }

    public void setGpsCord1(String gpsCord1) {
        this.gpsCord1 = gpsCord1;
    }

    public String getGpsCord2() {
        return gpsCord2;
    }

    public void setGpsCord2(String gpsCord2) {
        this.gpsCord2 = gpsCord2;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getAucCategoryName() {
        return aucCategoryName;
    }

    public void setAucCategoryName(String aucCategoryName) {
        this.aucCategoryName = aucCategoryName;
    }

    public Integer getAucCategoryId() {
        return aucCategoryId;
    }

    public void setAucCategoryId(Integer aucCategoryId) {
        this.aucCategoryId = aucCategoryId;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getAuctioneerName() {
        return auctioneerName;
    }

    public void setAuctioneerName(String auctioneerName) {
        this.auctioneerName = auctioneerName;
    }

    public String getLogoName() {
        return logoName;
    }

    public void setLogoName(String logoName) {
        this.logoName = logoName;
    }

    public String getSellerLogo() {
        return sellerLogo;
    }

    public void setSellerLogo(String sellerLogo) {
        this.sellerLogo = sellerLogo;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }

    public String getTermsCondition() {
        return termsCondition;
    }

    public void setTermsCondition(String termsCondition) {
        this.termsCondition = termsCondition;
    }

    public String getAppLogo() {
        return appLogo;
    }

    public void setAppLogo(String appLogo) {
        this.appLogo = appLogo;
    }

    public String getSellerHpLogo() {
        return sellerHpLogo;
    }

    public void setSellerHpLogo(String sellerHpLogo) {
        this.sellerHpLogo = sellerHpLogo;
    }

    public String getCatalog() {
        return catalog;
    }

    public void setCatalog(String catalog) {
        this.catalog = catalog;
    }

    public String getExportCatalogue() {
        return exportCatalogue;
    }

    public void setExportCatalogue(String exportCatalogue) {
        this.exportCatalogue = exportCatalogue;
    }

    public String getOpenDate() {
        return openDate;
    }

    public void setOpenDate(String openDate) {
        this.openDate = openDate;
    }

    public String getCloseDate() {
        return closeDate;
    }

    public void setCloseDate(String closeDate) {
        this.closeDate = closeDate;
    }

    public String getLockReg() {
        return lockReg;
    }

    public void setLockReg(String lockReg) {
        this.lockReg = lockReg;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRemoveStatus() {
        return removeStatus;
    }

    public void setRemoveStatus(String removeStatus) {
        this.removeStatus = removeStatus;
    }

    public String getArchiveStatus() {
        return archiveStatus;
    }

    public void setArchiveStatus(String archiveStatus) {
        this.archiveStatus = archiveStatus;
    }

    public String getInterval() {
        return interval;
    }

    public void setInterval(String interval) {
        this.interval = interval;
    }

    public String getRejectBid() {
        return rejectBid;
    }

    public void setRejectBid(String rejectBid) {
        this.rejectBid = rejectBid;
    }

    public String getMobRejectBid() {
        return mobRejectBid;
    }

    public void setMobRejectBid(String mobRejectBid) {
        this.mobRejectBid = mobRejectBid;
    }

    public String getTransaction() {
        return transaction;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }
}
