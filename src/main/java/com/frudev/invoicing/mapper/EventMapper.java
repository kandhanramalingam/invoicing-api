package com.frudev.invoicing.mapper;

import com.frudev.invoicing.dto.EventDto;
import com.frudev.invoicing.entity.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring", uses = {AuctionMapper.class})
public interface EventMapper {
    @Mapping(source = "auction.id", target = "auctionId")
    EventDto toDto(EventEntity entity);

    @Mapping(source = "auctionId", target = "auction.id")
    @Mapping(target = "id", ignore = true)
    EventEntity toEntity(EventDto dto);

    @Mapping(target = "auction", ignore = true)
    @Mapping(target = "id", ignore = true)
    void updateEntityFromDto(EventDto dto, @MappingTarget EventEntity entity);
}
