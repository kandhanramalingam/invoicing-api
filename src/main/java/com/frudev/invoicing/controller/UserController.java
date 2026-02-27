package com.frudev.invoicing.controller;

import com.frudev.invoicing.dto.*;
import com.frudev.invoicing.service.UserService;
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
@RequestMapping("/users")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @PreAuthorize("hasAuthority('user-write')")
    public ResponseEntity<ResponseDto<UserDTO>> create(@RequestBody UserCreateDTO userDTO) {
        try {
            UserDTO created = userService.create(userDTO);
            return new ResponseEntity<>(new ResponseDto<>(created, "User created successfully"), HttpStatus.CREATED);
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("create user: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('user-write')")
    public ResponseEntity<ResponseDto<UserDTO>> update(@PathVariable UUID id, @RequestBody UserCreateDTO userDTO) {
        try {
            UserDTO updated = userService.update(id, userDTO);
            return ResponseEntity.ok(new ResponseDto<>(updated, "User updated successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("update user: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @PatchMapping("/{id}/password")
    public ResponseEntity<ResponseDto<Void>> updatePassword(@PathVariable UUID id, @RequestBody PasswordUpdateDTO passwordUpdateDTO) {
        try {
            userService.updatePassword(id, passwordUpdateDTO);
            return ResponseEntity.ok(new ResponseDto<>(null, "Password updated successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("update password: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasAuthority('user-write')")
    public ResponseEntity<ResponseDto<Void>> delete(@PathVariable UUID id) {
        try {
            userService.delete(id);
            return ResponseEntity.ok(new ResponseDto<>(null, "User deleted successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("delete user: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasAuthority('user-read')")
    public ResponseEntity<ResponseDto<UserDTO>> getById(@PathVariable UUID id) {
        try {
            UserDTO user = userService.getById(id);
            return ResponseEntity.ok(new ResponseDto<>(user, "User fetched successfully"));
        } catch (CustomException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            logger.error("getById user: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }

    @GetMapping
    @PreAuthorize("hasAuthority('user-read')")
    public ResponseEntity<ResponseDto<PaginatedDetailsDto<UserDTO>>> getAll(
            @RequestParam(required = false) String search, Pageable pageable) {
        try {
            PaginatedDetailsDto<UserDTO> users = userService.getAll(search, pageable);
            return ResponseEntity.ok(new ResponseDto<>(users, "Users fetched successfully"));
        } catch (Exception e) {
            logger.error("getAll users: ", e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }
}
