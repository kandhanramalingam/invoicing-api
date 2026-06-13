package com.frudev.invoicing.service;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.SellerDto;
import com.frudev.invoicing.entity.WldLwaSellersInfoEntity;
import com.frudev.invoicing.repository.WldLwaSellersInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SellerServiceImpl implements SellerService {

    @Autowired
    private WldLwaSellersInfoRepository sellerRepository;

    @Override
    public PaginatedDetailsDto<SellerDto> getSellersByAuctionId(Integer auctionId, Pageable pageable) {
        Page<WldLwaSellersInfoEntity> sellerPage = sellerRepository.findByAuctionId(auctionId, pageable);

        List<SellerDto> records = sellerPage.getContent().stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());

        return new PaginatedDetailsDto<>(
                sellerPage.getNumber(),
                sellerPage.getSize(),
                sellerPage.getTotalPages(),
                sellerPage.getTotalElements(),
                records
        );
    }

    @Override
    public void updateCommission(Long sellerInfoAutoid, Float commission) {
        WldLwaSellersInfoEntity seller = sellerRepository.findById(sellerInfoAutoid)
                .orElseThrow(() -> new RuntimeException("Seller not found"));
        seller.setCommission(commission);
        sellerRepository.save(seller);
    }

    private SellerDto mapToDto(WldLwaSellersInfoEntity entity) {
        SellerDto dto = new SellerDto();
        dto.setSellerInfoAutoid(entity.getSellerInfoAutoid());
        dto.setAuctionId(entity.getAuctionId());
        dto.setSellerId(entity.getSellerId());
        dto.setSellerName(entity.getSellerName());
        dto.setCompanyName(entity.getCompanyName());
        dto.setEmail(entity.getEmail());
        dto.setContact(entity.getContact());
        dto.setSellerLogo(entity.getSellerLogo());
        dto.setCommission(entity.getCommission());
        dto.setCreatedOn(entity.getCreatedOn());
        return dto;
    }
}
