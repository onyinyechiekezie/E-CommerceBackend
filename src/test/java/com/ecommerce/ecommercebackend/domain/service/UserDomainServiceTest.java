package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.enums.Role;
import com.ecommerce.ecommercebackend.domain.exception.DuplicateEmailException;
import com.ecommerce.ecommercebackend.domain.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.*;


class UserDomainServiceTest {

    private PasswordPolicyService passwordPolicyService;
    private UserDomainService userDomainService;
    private List<User> existingUsers;

    @BeforeEach
    void setUp() {
        passwordPolicyService = mock(PasswordPolicyService.class);
        userDomainService = new UserDomainService(passwordPolicyService);

        existingUsers = new ArrayList<>();
        existingUsers.add(new User(
                UUID.randomUUID(),
                "John Doe",
                "john@example.com",
                "hashedPassword123",
                Role.CUSTOMER,
                true,
                LocalDateTime.now(),
                LocalDateTime.now()
        ));
    }

    @Test
    @DisplayName("Should create user successfully when email is unique and password valid")
    void shouldCreateUserSuccessfully() {
        doNothing().when(passwordPolicyService).validatePassword("StrongPass@123");
        when(passwordPolicyService.hashPassword("StrongPass@123")).thenReturn("hashedValue123");
        User newUser = userDomainService.createUser(
                "Jane Doe",
                "jane@example.com",
                "StrongPass@123",
                Role.CUSTOMER,
                existingUsers
        );
        assertThat(newUser).isNotNull();
        assertThat(newUser.getEmail()).isEqualTo("jane@example.com");
        assertThat(newUser.getPasswordHash()).isEqualTo("hashedValue123");
        assertThat(newUser.isActive()).isTrue();
    }

    @Test
    @DisplayName("Should throw DuplicateEmailException if email already exists")
    void shouldThrowDuplicateEmailException() {
        doNothing().when(passwordPolicyService).validatePassword("StrongPass@123");
        when(passwordPolicyService.hashPassword("StrongPass@123")).thenReturn("hashedValue123");
        assertThatThrownBy(() ->
                userDomainService.createUser(
                        "Duplicate User",
                        "john@example.com", // duplicate
                        "StrongPass@123",
                        Role.CUSTOMER,
                        existingUsers
                )
        )
                .isInstanceOf(DuplicateEmailException.class)
                .hasMessage("Email already exists");
    }

    @Test
    @DisplayName("Should deactivate active user successfully")
    void shouldDeactivateUser() {
        User activeUser = existingUsers.get(0);
        User deactivated = userDomainService.deactivateUser(activeUser);
        assertThat(deactivated.isActive()).isFalse();
        assertThat(deactivated.getUpdatedAt()).isAfter(deactivated.getCreatedAt());
    }
}
