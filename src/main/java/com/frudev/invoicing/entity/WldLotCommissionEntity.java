package com.frudev.invoicing.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "wld_lot_commission")
public class WldLotCommissionEntity extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "lot_id", nullable = false)
    private Integer lotId;

    @Column(name = "seller_id", nullable = false)
    private Integer sellerId;

    @Column(name = "commission", nullable = false)
    private Float commission;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLotId() {
        return lotId;
    }

    public void setLotId(Integer lotId) {
        this.lotId = lotId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Float getCommission() {
        return commission;
    }

    public void setCommission(Float commission) {
        this.commission = commission;
    }
}
