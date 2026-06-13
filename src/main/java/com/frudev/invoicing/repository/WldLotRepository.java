package com.frudev.invoicing.repository;

import com.frudev.invoicing.entity.WldLotEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface WldLotRepository extends JpaRepository<WldLotEntity, Integer> {

    @Query(value = "SELECT l.id, " +
            "       l.mainlotno, " +
            "       l.description, " +
            "       l.price, " +
            "       l.sum_total, " +
            "       l.VMStatus, " +
            "       COALESCE(u.firstName, " +
            "                CASE WHEN ua.user_id REGEXP '^[0-9]+$' " +
            "                         THEN NULL " +
            "                     ELSE ua.user_id " +
            "                    END) as buyerFirstName, " +
            "       COALESCE(u.lastName, '') as buyerLastName, " +
            "       l.userid, " +
            "       l.auction_id, " +
            "       l.seller, " +
            "       s.seller_name as sellerName, " +
            "       ua.user_id as user_id, " +
            "       ua.bidder_no as bidder_no " +
            "FROM wld_lotset l " +
            "         LEFT JOIN wld_user_auctions ua ON l.wla_lotno = ua.game_id " +
            "         LEFT JOIN wld_users u ON CASE WHEN ua.user_id REGEXP '^[0-9]+$' " +
            "                                         THEN CAST(ua.user_id AS UNSIGNED) = u.id " +
            "                                     ELSE FALSE " +
            "    END " +
            "         LEFT JOIN wld_lwa_sellers_info s ON l.seller = s.seller_id AND l.auction_id = s.auction_id " +
            "WHERE l.auction_id = :auctionId",
            countQuery = "SELECT COUNT(*) FROM wld_lotset l WHERE l.auction_id = :auctionId",
            nativeQuery = true)
    Page<Map<String, Object>> findLotDetailsByAuctionId(@Param("auctionId") Integer auctionId, Pageable pageable);
}
