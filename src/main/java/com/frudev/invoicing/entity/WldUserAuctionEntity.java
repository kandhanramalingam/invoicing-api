package com.frudev.invoicing.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "wld_user_auctions")
public class WldUserAuctionEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "game_id", length = 1000, nullable = false)
    private String gameId;

    @Column(name = "user_id", length = 50, nullable = false)
    private String userId;

    @Column(name = "bidder_no", nullable = false)
    private Integer bidderNo;

    @Column(name = "auction_date", nullable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime auctionDate;

    @Column(name = "auction_id", nullable = false)
    private Integer auctionId;

    @Column(name = "auction_price", nullable = false)
    private Float auctionPrice;

    @Column(name = "total_auction_price", nullable = false)
    private Integer totalAuctionPrice;

    @Column(name = "status", nullable = false)
    private String status; // Enum('Pending','Allotted','Cancel','Waiting')

    @Column(name = "VMStatus", nullable = false)
    private String vmStatus; // Enum('Sold','Not Sold','S.T.C','Consolidated')

    @Column(name = "auction_type")
    private String auctionType; // Enum('website','live')

    @Column(name = "created_on", nullable = false)
    private LocalDateTime createdOn;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGameId() {
        return gameId;
    }

    public void setGameId(String gameId) {
        this.gameId = gameId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getBidderNo() {
        return bidderNo;
    }

    public void setBidderNo(Integer bidderNo) {
        this.bidderNo = bidderNo;
    }

    public LocalDateTime getAuctionDate() {
        return auctionDate;
    }

    public void setAuctionDate(LocalDateTime auctionDate) {
        this.auctionDate = auctionDate;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Float getAuctionPrice() {
        return auctionPrice;
    }

    public void setAuctionPrice(Float auctionPrice) {
        this.auctionPrice = auctionPrice;
    }

    public Integer getTotalAuctionPrice() {
        return totalAuctionPrice;
    }

    public void setTotalAuctionPrice(Integer totalAuctionPrice) {
        this.totalAuctionPrice = totalAuctionPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getVmStatus() {
        return vmStatus;
    }

    public void setVmStatus(String vmStatus) {
        this.vmStatus = vmStatus;
    }

    public String getAuctionType() {
        return auctionType;
    }

    public void setAuctionType(String auctionType) {
        this.auctionType = auctionType;
    }

    public LocalDateTime getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(LocalDateTime createdOn) {
        this.createdOn = createdOn;
    }
}
