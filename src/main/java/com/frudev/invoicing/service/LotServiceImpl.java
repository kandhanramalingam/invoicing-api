package com.frudev.invoicing.service;

import com.frudev.invoicing.dto.GroupedLotDto;
import com.frudev.invoicing.dto.GroupedSellerLotDto;
import com.frudev.invoicing.dto.LotDetailDto;
import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.repository.WldLotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class LotServiceImpl implements LotService {

    @Autowired
    private WldLotRepository lotRepository;

    @Override
    public PaginatedDetailsDto<LotDetailDto> getLotDetailsByAuctionId(Integer auctionId, Pageable pageable) {
        Page<Map<String, Object>> lotPage = lotRepository.findLotDetailsByAuctionId(auctionId, pageable);

        List<LotDetailDto> records = lotPage.getContent().stream().map(this::mapToDto).collect(Collectors.toList());

        return new PaginatedDetailsDto<>(
                lotPage.getNumber(),
                lotPage.getSize(),
                lotPage.getTotalPages(),
                lotPage.getTotalElements(),
                records
        );
    }

    @Override
    public List<GroupedLotDto> getLotDetailsGroupByBuyerByAuctionId(Integer auctionId) {
        // Fetch all lots for grouping (no pagination)
        Page<Map<String, Object>> lotPage = lotRepository.findLotDetailsByAuctionId(auctionId, PageRequest.of(0, 5000));
        List<LotDetailDto> allLots = lotPage.getContent().stream().map(this::mapToDto).collect(Collectors.toList());

        // Group by user_id
        Map<Integer, List<LotDetailDto>> grouped = allLots.stream()
                .collect(Collectors.groupingBy(lot -> lot.getUser_id() != null ? lot.getUser_id() : (lot.getUserId() != null ? lot.getUserId() : 0), LinkedHashMap::new, Collectors.toList()));

        List<GroupedLotDto> result = new ArrayList<>();
        grouped.forEach((userId, lots) -> {
            if (!lots.isEmpty()) {
                LotDetailDto first = lots.get(0);
                result.add(new GroupedLotDto(userId, first.getBuyerFirstName(), first.getBuyerLastName(), first.getBidder_no(), lots));
            }
        });

        return result;
    }

    @Override
    public List<GroupedSellerLotDto> getLotDetailsGroupBySellerByAuctionId(Integer auctionId) {
        // Fetch all lots for grouping (no pagination)
        Page<Map<String, Object>> lotPage = lotRepository.findLotDetailsByAuctionId(auctionId, PageRequest.of(0, 5000));
        List<LotDetailDto> allLots = lotPage.getContent().stream().map(this::mapToDto).collect(Collectors.toList());

        // Group by seller
        Map<String, List<LotDetailDto>> grouped = allLots.stream()
                .collect(Collectors.groupingBy(lot -> lot.getSeller() != null ? lot.getSeller() : "Unknown", LinkedHashMap::new, Collectors.toList()));

        List<GroupedSellerLotDto> result = new ArrayList<>();
        grouped.forEach((seller, lots) -> {
            String sellerName = lots.isEmpty() ? "Unknown" : lots.get(0).getSellerName();
            result.add(new GroupedSellerLotDto(seller, sellerName, lots));
        });

        return result;
    }

    private LotDetailDto mapToDto(Map<String, Object> map) {
        return new LotDetailDto(
                (Integer) map.get("id"),
                map.get("mainlotno") != null ? map.get("mainlotno").toString() : null,
                map.get("description") != null ? map.get("description").toString() : null,
                map.get("price") != null ? map.get("price").toString() : null,
                (Integer) map.get("sum_total"),
                map.get("VMStatus") != null ? map.get("VMStatus").toString() : null,
                map.get("buyerFirstName") != null ? map.get("buyerFirstName").toString() : null,
                map.get("buyerLastName") != null ? map.get("buyerLastName").toString() : null,
                (Integer) map.get("userid"),
                (Integer) map.get("auction_id"),
                map.get("user_id") instanceof Integer ? (Integer) map.get("user_id") : (map.get("user_id") != null && map.get("user_id").toString().matches("-?\\d+") ? Integer.parseInt(map.get("user_id").toString()) : null),
                map.get("bidder_no") != null ? map.get("bidder_no").toString() : null,
                map.get("seller") != null ? map.get("seller").toString() : null,
                map.get("sellerName") != null ? map.get("sellerName").toString() : null
        );
    }
}
