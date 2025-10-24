package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.exception.InvalidPasswordException;
import org.mindrot.jbcrypt.BCrypt;

public class PasswordPolicyService {

    public void validatePassword(String password) {
        if (password == null || password.isBlank()) {
            throw new InvalidPasswordException("Password cannot be empty");
        }
        if (password.length() < 8 || !password.matches(".*[A-Z].*") || !password.matches(".*[0-9].*"))
            throw new InvalidPasswordException("Password must be at least 8 characters, include one uppercase letter and one number");
    }

    public String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public boolean verifyPassword(String raw, String hash) {
        return BCrypt.checkpw(raw, hash);
    }
}
