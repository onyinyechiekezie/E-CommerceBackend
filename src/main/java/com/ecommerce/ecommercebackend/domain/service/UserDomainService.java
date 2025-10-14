package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.model.User;
import com.ecommerce.ecommercebackend.domain.enums.Role;
import java.util.UUID;

public class UserDomainService {

    public User createUser(String name, String email, String password, Role role) {
        return new User(UUID.randomUUID(), name, email, password, role, true,
                java.time.LocalDateTime.now(), java.time.LocalDateTime.now());
    }

    public User activateUser(User user) {
        return new User(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                true,
                user.getCreatedAt(),
                java.time.LocalDateTime.now()
        );
    }

    public User deactivateUser(User user) {
        return new User(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getPassword(),
                user.getRole(),
                false,
                user.getCreatedAt(),
                java.time.LocalDateTime.now()
        );
    }
}
