package com.ecommerce.ecommercebackend.domain.model;

import com.ecommerce.ecommercebackend.domain.enums.Role;
import java.time.LocalDateTime;
import java.util.UUID;

public class User {

    private final UUID id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private boolean active;
    private final LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public User(UUID id, String name, String email, String password, Role role,
                boolean active, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.role = role;
        this.active = active;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }
    public Role getRole() { return role; }
    public boolean isActive() { return active; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}
