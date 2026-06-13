package com.frudev.invoicing.repository;

import com.frudev.invoicing.entity.WldLotCommissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WldLotCommissionRepository extends JpaRepository<WldLotCommissionEntity, Long> {
    List<WldLotCommissionEntity> findByLotId(Integer lotId);
    List<WldLotCommissionEntity> findBySellerId(Integer sellerId);
}
