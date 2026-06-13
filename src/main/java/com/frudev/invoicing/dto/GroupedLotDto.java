package com.frudev.invoicing.dto;

import java.util.List;

public class GroupedLotDto {
    private Integer userId;
    private String buyerFirstName;
    private String buyerLastName;
    private String bidderNo;
    private List<LotDetailDto> lots;

    public GroupedLotDto(Integer userId, String firstName, String lastName, String bidderNo, List<LotDetailDto> lots) {
        this.userId = userId;
        this.buyerFirstName = firstName;
        this.buyerLastName = lastName;
        this.bidderNo = bidderNo;
        this.lots = lots;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getBuyerFirstName() {
        return buyerFirstName;
    }

    public void setBuyerFirstName(String buyerFirstName) {
        this.buyerFirstName = buyerFirstName;
    }

    public String getBuyerLastName() {
        return buyerLastName;
    }

    public void setBuyerLastName(String buyerLastName) {
        this.buyerLastName = buyerLastName;
    }

    public String getBidderNo() {
        return bidderNo;
    }

    public void setBidderNo(String bidderNo) {
        this.bidderNo = bidderNo;
    }

    public List<LotDetailDto> getLots() {
        return lots;
    }

    public void setLots(List<LotDetailDto> lots) {
        this.lots = lots;
    }
}
