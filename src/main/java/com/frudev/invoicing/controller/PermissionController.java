package com.frudev.invoicing.controller;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.PermissionDTO;
import com.frudev.invoicing.dto.ResponseDto;
import com.frudev.invoicing.service.PermissionService;
import com.frudev.invoicing.utils.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/permissions")
public class PermissionController {

    private static final Logger logger = LoggerFactory.getLogger(PermissionController.class);
    private final PermissionService permissionService;

    public PermissionController(PermissionService permissionService) {
        this.permissionService = permissionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<PermissionDTO>> getById(@PathVariable UUID id) {
        try {
            PermissionDTO permission = permissionService.getById(id);
            return ResponseEntity.ok(new ResponseDto<>(permission, "Permission fetched successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("getById permission: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @GetMapping
    public ResponseEntity<ResponseDto<PaginatedDetailsDto<PermissionDTO>>> getAll(Pageable pageable) {
        try {
            PaginatedDetailsDto<PermissionDTO> permissions = permissionService.getAll(pageable);
            return ResponseEntity.ok(new ResponseDto<>(permissions, "Permissions fetched successfully"));
        } catch (Exception e) {
            logger.error("getAll permissions: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }
}
