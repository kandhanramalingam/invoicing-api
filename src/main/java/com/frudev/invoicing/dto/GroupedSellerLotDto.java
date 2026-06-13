package com.frudev.invoicing.dto;

import java.util.List;

public class GroupedSellerLotDto {
    private String seller;
    private String sellerName;
    private List<LotDetailDto> lots;

    public GroupedSellerLotDto(String seller, String sellerName, List<LotDetailDto> lots) {
        this.seller = seller;
        this.sellerName = sellerName;
        this.lots = lots;
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

    public List<LotDetailDto> getLots() {
        return lots;
    }

    public void setLots(List<LotDetailDto> lots) {
        this.lots = lots;
    }
}
