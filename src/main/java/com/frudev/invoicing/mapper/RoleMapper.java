package com.frudev.invoicing.mapper;

import com.frudev.invoicing.dto.RoleCreateDTO;
import com.frudev.invoicing.dto.RoleDTO;
import com.frudev.invoicing.entity.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {PermissionMapper.class})
public interface RoleMapper {

    @Mapping(target = "permissions", source = "permissions")
    RoleDTO toDto(RoleEntity role);

    @Mapping(target = "permissions", ignore = true)
    RoleEntity toEntity(RoleCreateDTO roleDTO);

    List<RoleDTO> toDtoList(List<RoleEntity> roles);
}
