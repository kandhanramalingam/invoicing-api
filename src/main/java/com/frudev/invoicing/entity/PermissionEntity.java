package com.frudev.invoicing.entity;

import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
@Table(name = "wld_inv_permissions")
public class PermissionEntity extends Auditable {
    @Id
    @Column(nullable = false, updatable = false)
    private UUID id;

    @Column(name = "NAME", nullable = false, unique = true)
    private String name;


    @ManyToMany(mappedBy = "permissions")
    private Set<RoleEntity> roles = new HashSet<>();

    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Set<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(Set<RoleEntity> roles) {
        this.roles = roles;
    }
}

