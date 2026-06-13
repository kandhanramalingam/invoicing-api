package com.frudev.invoicing.mapper;

import com.frudev.invoicing.dto.AuctionDto;
import com.frudev.invoicing.dto.AuctionSimpleDto;
import com.frudev.invoicing.entity.AuctionEntity;
import org.mapstruct.Mapper;

import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuctionMapper {
    AuctionDto toDto(AuctionEntity entity);

    AuctionSimpleDto toSimpleDto(AuctionEntity entity);
}
