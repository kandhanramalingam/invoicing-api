package com.frudev.invoicing.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wld_lotset")
public class WldLotEntity {

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "auction_id", nullable = false)
    private Integer auctionId;

    @Column(name = "userid", nullable = false)
    private Integer userid;

    @Column(name = "mainlotno", length = 20, nullable = false)
    private String mainLotNo;

    @Column(name = "consolLotIds", length = 200, nullable = false)
    private String consolLotIds;

    @Column(name = "wla_lotno", length = 100, nullable = false)
    private String wlaLotNo;

    @Column(name = "users_for_auction_alert", columnDefinition = "TEXT")
    private String usersForAuctionAlert;

    @Column(name = "seller", length = 100, nullable = false)
    private String seller;

    @Column(name = "language", nullable = false)
    private String language;

    @Column(name = "price", nullable = false)
    private String price;

    @Column(name = "weightPrincple", nullable = false)
    private String weightPrincple;

    @Column(name = "tagno", length = 50, nullable = false)
    private String tagNo;

    @Column(name = "lot_insurance", nullable = false)
    private String lotInsurance;

    @Column(name = "game_capture_cost", nullable = false)
    private String gameCaptureCost;

    @Column(name = "boma_type", length = 20, nullable = false)
    private String bomaType;

    @Column(name = "permit_cost", nullable = false)
    private String permitCost;

    @Column(name = "transport_date", length = 20, nullable = false)
    private String transportDate;

    @Column(name = "delivery_cost", length = 10, nullable = false)
    private String deliveryCost;

    @Column(name = "free_kilometers", length = 100, nullable = false)
    private String freeKilometers;

    @Column(name = "province_id", length = 25, nullable = false)
    private String provinceId;

    @Column(name = "city_id", length = 25, nullable = false)
    private String cityId;

    @Column(name = "description", columnDefinition = "TEXT", nullable = false)
    private String description;

    @Column(name = "lot_image0", columnDefinition = "TEXT", nullable = false)
    private String lotImage0;

    @Column(name = "lot_liveimage", length = 100, nullable = false)
    private String lotLiveImage;

    @Column(name = "auction_status", nullable = false)
    private String auctionStatus;

    @Column(name = "VMStatus", nullable = false)
    private String vmStatus;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "admin_status", nullable = false)
    private String adminStatus;

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    @Column(name = "sum_male", nullable = false)
    private Integer sumMale;

    @Column(name = "sum_female", nullable = false)
    private Integer sumFemale;

    @Column(name = "sum_total", nullable = false)
    private Integer sumTotal;

    @Column(name = "sublot_type", nullable = false)
    private String sublotType;

    @Column(name = "lottype", nullable = false)
    private String lotType;

    @Column(name = "Avg_wt_per_unit_Kg", nullable = false)
    private Float avgWtPerUnitKg;

    @Column(name = "Actual_wt_per_unit_Kg", nullable = false)
    private Float actualWtPerUnitKg;

    @Column(name = "Avg_wt_per_lot_Kg", nullable = false)
    private Float avgWtPerLotKg;

    @Column(name = "Actual_wt_per_lot_Kg", nullable = false)
    private Float actualWtPerLotKg;

    @Column(name = "lot_image1", length = 100, nullable = false)
    private String lotImage1;

    @Column(name = "add_info_status", nullable = false)
    private String addInfoStatus;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @Column(name = "lot_notes", columnDefinition = "TEXT", nullable = false)
    private String lotNotes;

    @Column(name = "silent_interval", nullable = false)
    private Float silentInterval;

    @Column(name = "incrementGroup", nullable = false)
    private Integer incrementGroup;

    @Column(name = "targetPrice", nullable = false)
    private Long targetPrice;

    @Column(name = "openingBid", nullable = false)
    private Float openingBid;

    @Column(name = "archive_status", nullable = false)
    private String archiveStatus;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getMainLotNo() {
        return mainLotNo;
    }

    public void setMainLotNo(String mainLotNo) {
        this.mainLotNo = mainLotNo;
    }

    public String getConsolLotIds() {
        return consolLotIds;
    }

    public void setConsolLotIds(String consolLotIds) {
        this.consolLotIds = consolLotIds;
    }

    public String getWlaLotNo() {
        return wlaLotNo;
    }

    public void setWlaLotNo(String wlaLotNo) {
        this.wlaLotNo = wlaLotNo;
    }

    public String getUsersForAuctionAlert() {
        return usersForAuctionAlert;
    }

    public void setUsersForAuctionAlert(String usersForAuctionAlert) {
        this.usersForAuctionAlert = usersForAuctionAlert;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getWeightPrincple() {
        return weightPrincple;
    }

    public void setWeightPrincple(String weightPrincple) {
        this.weightPrincple = weightPrincple;
    }

    public String getTagNo() {
        return tagNo;
    }

    public void setTagNo(String tagNo) {
        this.tagNo = tagNo;
    }

    public String getLotInsurance() {
        return lotInsurance;
    }

    public void setLotInsurance(String lotInsurance) {
        this.lotInsurance = lotInsurance;
    }

    public String getGameCaptureCost() {
        return gameCaptureCost;
    }

    public void setGameCaptureCost(String gameCaptureCost) {
        this.gameCaptureCost = gameCaptureCost;
    }

    public String getBomaType() {
        return bomaType;
    }

    public void setBomaType(String bomaType) {
        this.bomaType = bomaType;
    }

    public String getPermitCost() {
        return permitCost;
    }

    public void setPermitCost(String permitCost) {
        this.permitCost = permitCost;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    public String getDeliveryCost() {
        return deliveryCost;
    }

    public void setDeliveryCost(String deliveryCost) {
        this.deliveryCost = deliveryCost;
    }

    public String getFreeKilometers() {
        return freeKilometers;
    }

    public void setFreeKilometers(String freeKilometers) {
        this.freeKilometers = freeKilometers;
    }

    public String getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(String provinceId) {
        this.provinceId = provinceId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLotImage0() {
        return lotImage0;
    }

    public void setLotImage0(String lotImage0) {
        this.lotImage0 = lotImage0;
    }

    public String getLotLiveImage() {
        return lotLiveImage;
    }

    public void setLotLiveImage(String lotLiveImage) {
        this.lotLiveImage = lotLiveImage;
    }

    public String getAuctionStatus() {
        return auctionStatus;
    }

    public void setAuctionStatus(String auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    public String getVmStatus() {
        return vmStatus;
    }

    public void setVmStatus(String vmStatus) {
        this.vmStatus = vmStatus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdminStatus() {
        return adminStatus;
    }

    public void setAdminStatus(String adminStatus) {
        this.adminStatus = adminStatus;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }

    public Integer getSumMale() {
        return sumMale;
    }

    public void setSumMale(Integer sumMale) {
        this.sumMale = sumMale;
    }

    public Integer getSumFemale() {
        return sumFemale;
    }

    public void setSumFemale(Integer sumFemale) {
        this.sumFemale = sumFemale;
    }

    public Integer getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(Integer sumTotal) {
        this.sumTotal = sumTotal;
    }

    public String getSublotType() {
        return sublotType;
    }

    public void setSublotType(String sublotType) {
        this.sublotType = sublotType;
    }

    public String getLotType() {
        return lotType;
    }

    public void setLotType(String lotType) {
        this.lotType = lotType;
    }

    public Float getAvgWtPerUnitKg() {
        return avgWtPerUnitKg;
    }

    public void setAvgWtPerUnitKg(Float avgWtPerUnitKg) {
        this.avgWtPerUnitKg = avgWtPerUnitKg;
    }

    public Float getActualWtPerUnitKg() {
        return actualWtPerUnitKg;
    }

    public void setActualWtPerUnitKg(Float actualWtPerUnitKg) {
        this.actualWtPerUnitKg = actualWtPerUnitKg;
    }

    public Float getAvgWtPerLotKg() {
        return avgWtPerLotKg;
    }

    public void setAvgWtPerLotKg(Float avgWtPerLotKg) {
        this.avgWtPerLotKg = avgWtPerLotKg;
    }

    public Float getActualWtPerLotKg() {
        return actualWtPerLotKg;
    }

    public void setActualWtPerLotKg(Float actualWtPerLotKg) {
        this.actualWtPerLotKg = actualWtPerLotKg;
    }

    public String getLotImage1() {
        return lotImage1;
    }

    public void setLotImage1(String lotImage1) {
        this.lotImage1 = lotImage1;
    }

    public String getAddInfoStatus() {
        return addInfoStatus;
    }

    public void setAddInfoStatus(String addInfoStatus) {
        this.addInfoStatus = addInfoStatus;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getLotNotes() {
        return lotNotes;
    }

    public void setLotNotes(String lotNotes) {
        this.lotNotes = lotNotes;
    }

    public Float getSilentInterval() {
        return silentInterval;
    }

    public void setSilentInterval(Float silentInterval) {
        this.silentInterval = silentInterval;
    }

    public Integer getIncrementGroup() {
        return incrementGroup;
    }

    public void setIncrementGroup(Integer incrementGroup) {
        this.incrementGroup = incrementGroup;
    }

    public Long getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(Long targetPrice) {
        this.targetPrice = targetPrice;
    }

    public Float getOpeningBid() {
        return openingBid;
    }

    public void setOpeningBid(Float openingBid) {
        this.openingBid = openingBid;
    }

    public String getArchiveStatus() {
        return archiveStatus;
    }

    public void setArchiveStatus(String archiveStatus) {
        this.archiveStatus = archiveStatus;
    }
}
