package com.frudev.invoicing.service;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.PermissionDTO;
import com.frudev.invoicing.mapper.PermissionMapper;
import com.frudev.invoicing.repository.PermissionRepository;
import com.frudev.invoicing.utils.CustomException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class PermissionService {

    private final PermissionRepository permissionRepository;
    private final PermissionMapper permissionMapper;

    public PermissionService(PermissionRepository permissionRepository, PermissionMapper permissionMapper) {
        this.permissionRepository = permissionRepository;
        this.permissionMapper = permissionMapper;
    }

    @Transactional(readOnly = true)
    public PermissionDTO getById(UUID id) {
        return permissionRepository.findById(id)
                .map(permissionMapper::toDto)
                .orElseThrow(() -> new CustomException("Permission not found."));
    }

    @Transactional(readOnly = true)
    public PaginatedDetailsDto<PermissionDTO> getAll(Pageable pageable) {
        Page<PermissionDTO> permissionPage = permissionRepository.findAll(pageable)
                .map(permissionMapper::toDto);
        
        return new PaginatedDetailsDto<>(
                permissionPage.getNumber(),
                permissionPage.getSize(),
                permissionPage.getTotalPages(),
                permissionPage.getTotalElements(),
                permissionPage.getContent()
        );
    }
}
