package com.ecommerce.ecommercebackend.domain.exception;

public class ComplianceViolationException extends RuntimeException {
    public ComplianceViolationException(String message) {
        super(message);
    }
}
