package com.frudev.invoicing.service;

import com.frudev.invoicing.dto.PaginatedDetailsDto;
import com.frudev.invoicing.dto.PasswordUpdateDTO;
import com.frudev.invoicing.dto.UserCreateDTO;
import com.frudev.invoicing.dto.UserDTO;
import com.frudev.invoicing.entity.UserEntity;
import com.frudev.invoicing.mapper.UserMapper;
import com.frudev.invoicing.repository.RoleRepository;
import com.frudev.invoicing.repository.UserRepository;
import com.frudev.invoicing.utils.CustomException;
import com.frudev.invoicing.utils.PasswordUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.UUID;

@Service
public class UserService {

    @Value("${app.default-password}")
    private String defaultPassword;

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, RoleRepository roleRepository,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.userMapper = userMapper;
    }

    @Transactional
    public UserDTO create(UserCreateDTO userDTO) {
        UserEntity user = userMapper.toEntity(userDTO);
        user.setPassword(PasswordUtil.encode(defaultPassword));
        if (userDTO.roleIds() != null) {
            user.setRoles(new HashSet<>(roleRepository.findAllById(userDTO.roleIds())));
        }
        user = userRepository.save(user);
        return userMapper.toDto(user);
    }

    @Transactional
    public UserDTO update(UUID id, UserCreateDTO userDTO) {
        UserEntity existingUser = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found with id: " + id));
        
        existingUser.setEmail(userDTO.email());
        existingUser.setFullName(userDTO.fullName());
        existingUser.setActive(userDTO.active());

        if (userDTO.roleIds() != null) {
            existingUser.setRoles(new HashSet<>(roleRepository.findAllById(userDTO.roleIds())));
        }
        
        return userMapper.toDto(existingUser);
    }

    @Transactional
    public void updatePassword(UUID id, PasswordUpdateDTO passwordUpdateDTO) {
        UserEntity user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found with id: " + id));

        if (!PasswordUtil.check(passwordUpdateDTO.currentPassword(), user.getPassword())) {
            throw new CustomException("Incorrect current password");
        }

        user.setPassword(PasswordUtil.encode(passwordUpdateDTO.newPassword()));
        userRepository.save(user);
    }

    @Transactional
    public void delete(UUID id) {
        if (!userRepository.existsById(id)) {
            throw new CustomException("User not found with id: " + id);
        }
        userRepository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public UserDTO getById(UUID id) {
        return userRepository.findById(id)
                .map(userMapper::toDto)
                .orElseThrow(() -> new CustomException("User not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public UserEntity getEntityByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new CustomException("User not found with email: " + email));
    }

    @Transactional(readOnly = true)
    public PaginatedDetailsDto<UserDTO> getAll(String search, Pageable pageable) {
        Specification<UserEntity> spec = buildSearchSpec(search);
        Page<UserDTO> userPage = userRepository.findAll(spec, pageable)
                .map(userMapper::toDto);

        return new PaginatedDetailsDto<>(
                userPage.getNumber(),
                userPage.getSize(),
                userPage.getTotalPages(),
                userPage.getTotalElements(),
                userPage.getContent()
        );
    }

    private Specification<UserEntity> buildSearchSpec(String search) {
        if (search == null || search.isBlank()) return null;
        String pattern = "%" + search.toLowerCase() + "%";
        return (root, query, cb) -> cb.or(
                cb.like(cb.lower(root.get("fullName")), pattern),
                cb.like(cb.lower(root.get("email")), pattern)
        );
    }
}
