package com.frudev.invoicing.repository;

import com.frudev.invoicing.dto.AuctionSimpleDto;
import com.frudev.invoicing.entity.AuctionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends JpaRepository<AuctionEntity, Long>, JpaSpecificationExecutor<AuctionEntity> {

    @Query("SELECT new com.frudev.invoicing.dto.AuctionSimpleDto(a.id, a.nameOfAuction, a.dateOfAuction, a.gpsCord1, a.gpsCord2) " +
           "FROM AuctionEntity a")
    Page<AuctionSimpleDto> findAllSimple(Pageable pageable);
}
