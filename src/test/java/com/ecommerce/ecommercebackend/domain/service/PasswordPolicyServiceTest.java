package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.exception.InvalidPasswordException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PasswordPolicyServiceTest {

    private PasswordPolicyService passwordPolicyService;

    @BeforeEach
    void setUp() {
        passwordPolicyService = new PasswordPolicyService();
    }

    @Test
    @DisplayName("Should pass validation for a strong password")
    void shouldPassValidationForStrongPassword() {
        String strongPassword = "StrongPass1";
        assertThatCode(() -> passwordPolicyService.validatePassword(strongPassword))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("Should throw exception for empty password")
    void shouldThrowForEmptyPassword() {
        assertThatThrownBy(() -> passwordPolicyService.validatePassword(""))
                .isInstanceOf(InvalidPasswordException.class)
                .hasMessage("Password cannot be empty");
    }

    @Test
    @DisplayName("Should throw exception for short or weak password")
    void shouldThrowForShortOrWeakPassword() {
        String[] weakPasswords = {
                "Abc12",      // too short
                "weakpass1",  // no uppercase
                "WeakPass"    // no number
        };

        for (String weak : weakPasswords) {
            assertThatThrownBy(() -> passwordPolicyService.validatePassword(weak))
                    .isInstanceOf(InvalidPasswordException.class)
                    .hasMessage("Password must be at least 8 characters, include one uppercase letter and one number");
        }
    }

    @Test
    @DisplayName("Should hash and verify password successfully")
    void shouldHashAndVerifyPassword() {
        String password = "StrongPass1";
        String hash = passwordPolicyService.hashPassword(password);

        assertThat(hash).isNotBlank();
        assertThat(passwordPolicyService.verifyPassword(password, hash)).isTrue();
    }

    @Test
    @DisplayName("Should fail verification when password does not match hash")
    void shouldFailVerificationForWrongPassword() {
        String password = "StrongPass1";
        String hash = passwordPolicyService.hashPassword(password);

        assertThat(passwordPolicyService.verifyPassword("WrongPass1", hash)).isFalse();
    }
}
