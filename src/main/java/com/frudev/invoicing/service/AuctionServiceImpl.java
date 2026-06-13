package com.frudev.invoicing.service;

import com.frudev.invoicing.dto.AuctionDto;
import com.frudev.invoicing.dto.AuctionSimpleDto;
import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.entity.AuctionEntity;
import com.frudev.invoicing.mapper.AuctionMapper;
import com.frudev.invoicing.repository.AuctionRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AuctionServiceImpl implements AuctionService {

    private final AuctionRepository auctionRepository;
    private final AuctionMapper auctionMapper;

    public AuctionServiceImpl(AuctionRepository auctionRepository, AuctionMapper auctionMapper) {
        this.auctionRepository = auctionRepository;
        this.auctionMapper = auctionMapper;
    }

    @Override
    @Transactional(readOnly = true)
    public PaginatedDetailsDto<?> getAll(String search, boolean lessDetails, Pageable pageable) {
        Specification<AuctionEntity> spec = buildSearchSpec(search);

        if (lessDetails) {
            // If no search is provided, we can use the optimized query
            if (spec == null) {
                Page<AuctionSimpleDto> page = auctionRepository.findAllSimple(pageable);
                return toPaginatedDto(page);
            }
            // If search is provided, we fall back to fetching entities and mapping
            // because @Query doesn't support Specification out of the box
            Page<AuctionEntity> page = auctionRepository.findAll(spec, pageable);
            Page<AuctionSimpleDto> simplePage = page.map(auctionMapper::toSimpleDto);
            return toPaginatedDto(simplePage);
        } else {
            Page<AuctionEntity> page = auctionRepository.findAll(spec, pageable);
            Page<AuctionDto> fullPage = page.map(auctionMapper::toDto);
            return toPaginatedDto(fullPage);
        }
    }

    private <T> PaginatedDetailsDto<T> toPaginatedDto(Page<T> page) {
        return new PaginatedDetailsDto<>(
                page.getNumber(),
                page.getSize(),
                page.getTotalPages(),
                page.getTotalElements(),
                page.getContent()
        );
    }

    private Specification<AuctionEntity> buildSearchSpec(String search) {
        if (search == null || search.isBlank()) {
            return null;
        }
        String pattern = "%" + search.toLowerCase() + "%";
        return (root, query, cb) -> cb.or(
                cb.like(cb.lower(root.get("nameOfAuction")), pattern),
                cb.like(cb.lower(root.get("sellerName")), pattern),
                cb.like(cb.lower(root.get("auctioneerName")), pattern)
        );
    }
}
