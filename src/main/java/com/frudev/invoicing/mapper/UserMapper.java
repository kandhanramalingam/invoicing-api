package com.frudev.invoicing.mapper;

import com.frudev.invoicing.dto.UserCreateDTO;
import com.frudev.invoicing.dto.UserDTO;
import com.frudev.invoicing.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    UserDTO toDto(UserEntity user);

    @Mapping(target = "roles", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "password", ignore = true)
    UserEntity toEntity(UserCreateDTO userDTO);

    List<UserDTO> toDtoList(List<UserEntity> users);
}
