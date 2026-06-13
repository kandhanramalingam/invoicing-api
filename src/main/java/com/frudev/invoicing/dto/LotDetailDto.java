package com.frudev.invoicing.dto;

public class LotDetailDto {
    private Integer id;
    private String mainLotNo;
    private String description;
    private String price;
    private Integer sumTotal;
    private String vmStatus;
    private String buyerFirstName;
    private String buyerLastName;
    private Integer userId;
    private Integer auctionId;
    private Integer user_id;
    private String bidder_no;
    private String seller;
    private String sellerName;

    public LotDetailDto(Integer id, String mainLotNo, String description, String price, Integer sumTotal, String vmStatus, String firstName, String lastName, Integer userId, Integer auctionId, Integer user_id, String bidder_no, String seller, String sellerName) {
        this.id = id;
        this.mainLotNo = mainLotNo;
        this.description = description;
        this.price = price;
        this.sumTotal = sumTotal;
        this.vmStatus = vmStatus;
        this.buyerFirstName = firstName;
        this.buyerLastName = lastName;
        this.userId = userId;
        this.auctionId = auctionId;
        this.user_id = user_id;
        this.bidder_no = bidder_no;
        this.seller = seller;
        this.sellerName = sellerName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMainLotNo() {
        return mainLotNo;
    }

    public void setMainLotNo(String mainLotNo) {
        this.mainLotNo = mainLotNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Integer getSumTotal() {
        return sumTotal;
    }

    public void setSumTotal(Integer sumTotal) {
        this.sumTotal = sumTotal;
    }

    public String getVmStatus() {
        return vmStatus;
    }

    public void setVmStatus(String vmStatus) {
        this.vmStatus = vmStatus;
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getAuctionId() {
        return auctionId;
    }

    public void setAuctionId(Integer auctionId) {
        this.auctionId = auctionId;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getBidder_no() {
        return bidder_no;
    }

    public void setBidder_no(String bidder_no) {
        this.bidder_no = bidder_no;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }
}
