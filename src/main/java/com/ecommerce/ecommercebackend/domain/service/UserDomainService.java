package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.exception.DuplicateEmailException;
import com.ecommerce.ecommercebackend.domain.exception.InvalidPasswordException;
import com.ecommerce.ecommercebackend.domain.model.User;
import com.ecommerce.ecommercebackend.domain.enums.Role;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class UserDomainService {

    private final PasswordPolicyService passwordPolicyService;

    public UserDomainService(PasswordPolicyService passwordPolicyService) {
        this.passwordPolicyService = passwordPolicyService;
    }

    public User createUser(String name, String email, String rawPassword, Role role, List<User> existingUsers) {
        validateUniqueEmail(email, existingUsers);
        passwordPolicyService.validatePassword(rawPassword);

        String passwordHash = passwordPolicyService.hashPassword(rawPassword);
        return new User(UUID.randomUUID(), name, email, passwordHash, role, true, LocalDateTime.now(), LocalDateTime.now());
    }

    public User deactivateUser(User user) {
        return new User(user.getId(), user.getName(), user.getEmail(), user.getPasswordHash(), user.getRole(), false, user.getCreatedAt(), LocalDateTime.now());
    }

    private void validateUniqueEmail(String email, List<User> existingUsers) {
        boolean exists = existingUsers.stream().anyMatch(u -> u.getEmail().equalsIgnoreCase(email));
        if (exists) throw new DuplicateEmailException("Email already exists");
    }
}
