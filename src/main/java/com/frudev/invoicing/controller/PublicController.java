package com.frudev.invoicing.controller;

import com.frudev.invoicing.dto.ResponseDto;
import com.frudev.invoicing.dto.UserDTO;
import com.frudev.invoicing.entity.PermissionEntity;
import com.frudev.invoicing.entity.RoleEntity;
import com.frudev.invoicing.entity.UserEntity;
import com.frudev.invoicing.mapper.UserMapper;
import com.frudev.invoicing.repository.PermissionRepository;
import com.frudev.invoicing.repository.RoleRepository;
import com.frudev.invoicing.repository.UserRepository;
import com.frudev.invoicing.utils.PasswordUtil;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@RestController
@RequestMapping("/public")
public class PublicController {

    private static final String SUPER_ADMIN_ROLE = "SUPER_ADMIN";

    private static final List<String> SUPER_ADMIN_PERMISSIONS = List.of(
            "user-read", "user-write", "role-read", "role-write", "permission-read", "permission-write"
    );

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PermissionRepository permissionRepository;
    private final UserMapper userMapper;

    public PublicController(UserRepository userRepository, RoleRepository roleRepository,
                            PermissionRepository permissionRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.userMapper = userMapper;
    }

    @PostMapping("/setup/super-admin")
    public ResponseEntity<ResponseDto<UserDTO>> createSuperAdmin(@RequestParam String password) {
        try {
            Set<PermissionEntity> permissions = new HashSet<>();
            for (String permName : SUPER_ADMIN_PERMISSIONS) {
                PermissionEntity permission = permissionRepository.findByName(permName)
                        .orElseGet(() -> {
                            PermissionEntity p = new PermissionEntity();
                            p.setId(UUID.randomUUID());
                            p.setName(permName);
                            return permissionRepository.save(p);
                        });
                permissions.add(permission);
            }

            RoleEntity superAdminRole = roleRepository.findByName(SUPER_ADMIN_ROLE)
                    .orElseGet(() -> {
                        RoleEntity role = new RoleEntity();
                        role.setId(UUID.randomUUID());
                        role.setName(SUPER_ADMIN_ROLE);
                        return roleRepository.save(role);
                    });

            superAdminRole.setPermissions(permissions);
            roleRepository.save(superAdminRole);

            boolean superAdminExists = userRepository.findAll().stream()
                    .anyMatch(user -> user.getRoles().stream()
                            .anyMatch(role -> SUPER_ADMIN_ROLE.equals(role.getName())));

            if (superAdminExists) {
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ResponseDto<>(null, "Super admin user already exists"));
            }

            UserEntity user = new UserEntity();
            user.setId(UUID.randomUUID());
            user.setEmail("superadmin@admin.com");
            user.setFullName("Super Admin");
            user.setPassword(PasswordUtil.encode(password));
            user.setActive(1);
            user.setRoles(Set.of(superAdminRole));

            user = userRepository.save(user);

            return new ResponseEntity<>(new ResponseDto<>(userMapper.toDto(user), "Super admin created successfully"), HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseDto<>(null, e.getMessage()));
        }
    }
}
