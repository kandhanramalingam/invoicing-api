package com.frudev.invoicing.mapper;

import com.frudev.invoicing.dto.PermissionDTO;
import com.frudev.invoicing.entity.PermissionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface PermissionMapper {
    PermissionDTO toDto(PermissionEntity permission);
    
    @Mapping(target = "roles", ignore = true)
    PermissionEntity toEntity(PermissionDTO permissionDTO);
    
    List<PermissionDTO> toDtoList(List<PermissionEntity> permissions);
}
