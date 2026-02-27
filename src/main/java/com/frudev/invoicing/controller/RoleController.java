package com.frudev.invoicing.controller;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.ResponseDto;
import com.frudev.invoicing.dto.RoleCreateDTO;
import com.frudev.invoicing.dto.RoleDTO;
import com.frudev.invoicing.service.RoleService;
import com.frudev.invoicing.utils.CustomException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);
    private final RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('role-read')")
    public ResponseEntity<ResponseDto<RoleDTO>> create(@RequestBody RoleCreateDTO roleDTO) {
        try {
            RoleDTO created = roleService.create(roleDTO);
            return new ResponseEntity<>(new ResponseDto<>(created, "Role created successfully"), HttpStatus.CREATED);
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("create role: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('role-write')")
    public ResponseEntity<ResponseDto<RoleDTO>> update(@PathVariable UUID id, @RequestBody RoleCreateDTO roleDTO) {
        try {
            RoleDTO updated = roleService.update(id, roleDTO);
            return ResponseEntity.ok(new ResponseDto<>(updated, "Role updated successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("update role: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('role-write')")
    public ResponseEntity<ResponseDto<Void>> delete(@PathVariable UUID id) {
        try {
            roleService.delete(id);
            return ResponseEntity.ok(new ResponseDto<>(null, "Role deleted successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("delete role: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('role-read')")
    public ResponseEntity<ResponseDto<RoleDTO>> getById(@PathVariable UUID id) {
        try {
            RoleDTO role = roleService.getById(id);
            return ResponseEntity.ok(new ResponseDto<>(role, "Role fetched successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("getById role: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('role-read')")
    public ResponseEntity<ResponseDto<PaginatedDetailsDto<RoleDTO>>> getAll(
            @RequestParam(required = false) String search, Pageable pageable) {
        try {
            PaginatedDetailsDto<RoleDTO> roles = roleService.getAll(search, pageable);
            return ResponseEntity.ok(new ResponseDto<>(roles, "Roles fetched successfully"));
        } catch (Exception e) {
            logger.error("getAll roles: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }
}
