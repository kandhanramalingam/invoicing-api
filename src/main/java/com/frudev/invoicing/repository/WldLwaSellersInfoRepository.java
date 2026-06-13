package com.frudev.invoicing.repository;

import com.frudev.invoicing.entity.WldLwaSellersInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WldLwaSellersInfoRepository extends JpaRepository<WldLwaSellersInfoEntity, Long> {
    Page<WldLwaSellersInfoEntity> findByAuctionId(Integer auctionId, Pageable pageable);
}
