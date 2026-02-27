package com.frudev.invoicing.service;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.RoleCreateDTO;
import com.frudev.invoicing.dto.RoleDTO;
import com.frudev.invoicing.entity.RoleEntity;
import com.frudev.invoicing.repository.PermissionRepository;
import com.frudev.invoicing.mapper.RoleMapper;
import com.frudev.invoicing.repository.RoleRepository;
import com.frudev.invoicing.utils.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.UUID;

@Service
public class RoleService {

    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final RoleMapper roleMapper;

    public RoleService(RoleRepository roleRepository, PermissionRepository permissionRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.roleMapper = roleMapper;
    }

    @Transactional
    public RoleDTO create(RoleCreateDTO roleDTO) {
        RoleEntity role = roleMapper.toEntity(roleDTO);
        if (roleDTO.permissionIds() != null) {
            role.setPermissions(new HashSet<>(permissionRepository.findAllById(roleDTO.permissionIds())));
        }
        role = roleRepository.save(role);
        return roleMapper.toDto(role);
    }

    @Transactional
    public RoleDTO update(UUID id, RoleCreateDTO roleDTO) {
        RoleEntity existingRole = roleRepository.findById(id)
                .orElseThrow(() -> new CustomException("Role not found."));
        
        existingRole.setName(roleDTO.name());
        if (roleDTO.permissionIds() != null) {
            existingRole.setPermissions(new HashSet<>(permissionRepository.findAllById(roleDTO.permissionIds())));
        }
        
        RoleEntity updatedRole = roleRepository.save(existingRole);
        return roleMapper.toDto(updatedRole);
    }

    @Transactional
    public void delete(UUID id) {
        if (!roleRepository.existsById(id)) {
            throw new CustomException("Role not found.");
        }
        roleRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public RoleDTO getById(UUID id) {
        return roleRepository.findById(id)
                .map(roleMapper::toDto)
                .orElseThrow(() -> new CustomException("Role not found."));
    }

    @Transactional(readOnly = true)
    public PaginatedDetailsDto<RoleDTO> getAll(String search, Pageable pageable) {
        Specification<RoleEntity> spec = buildSearchSpec(search);
        Page<RoleDTO> rolePage = roleRepository.findAll(spec, pageable)
                .map(roleMapper::toDto);

        return new PaginatedDetailsDto<>(
                rolePage.getNumber(),
                rolePage.getSize(),
                rolePage.getTotalPages(),
                rolePage.getTotalElements(),
                rolePage.getContent()
        );
    }

    private Specification<RoleEntity> buildSearchSpec(String search) {
        if (search == null || search.isBlank()) return null;
        String pattern = "%" + search.toLowerCase() + "%";
        return (root, query, cb) -> cb.like(cb.lower(root.get("name")), pattern);
    }
}
