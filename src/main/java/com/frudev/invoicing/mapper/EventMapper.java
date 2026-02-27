package com.frudev.invoicing.mapper;

import com.frudev.invoicing.dto.EventDto;
import com.frudev.invoicing.entity.EventEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface EventMapper {
    EventDto toDto(EventEntity entity);
    EventEntity toEntity(EventDto dto);
    void updateEntityFromDto(EventDto dto, @MappingTarget EventEntity entity);
}
