package com.frudev.invoicing.controller;

import com.frudev.invoicing.dto.AuthResponse;
import com.frudev.invoicing.dto.LoginRequest;
import com.frudev.invoicing.dto.ResponseDto;
import com.frudev.invoicing.entity.PermissionEntity;
import com.frudev.invoicing.entity.UserEntity;
import com.frudev.invoicing.service.UserService;
import com.frudev.invoicing.utils.CustomException;
import com.frudev.invoicing.utils.JwtUtil;
import com.frudev.invoicing.utils.PasswordUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<ResponseDto<AuthResponse>> login(@RequestBody LoginRequest loginRequest) {
        try {
            UserEntity user = userService.getEntityByEmail(loginRequest.email());

            if (!PasswordUtil.check(loginRequest.password(), user.getPassword())) {
                throw new CustomException("Invalid password");
            }

            if (user.getActive() != 1) {
                throw new CustomException("User account is not active");
            }

            List<String> permissions = user.getRoles().stream()
                    .flatMap(role -> role.getPermissions().stream())
                    .map(PermissionEntity::getName)
                    .distinct()
                    .collect(Collectors.toList());

            String token = jwtUtil.generateToken(user.getEmail(), user.getFullName(), permissions);

            AuthResponse authResponse = new AuthResponse(
                    token,
                    user.getEmail(),
                    user.getFullName(),
                    permissions
            );

            return ResponseEntity.ok(new ResponseDto<>(authResponse, "Login successful"));
        } catch (CustomException e) {
            return ResponseEntity.status(401).body(new ResponseDto<>(null, e.getMessage()));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ResponseDto<>(null, "An error occurred during login"));
        }
    }
}
