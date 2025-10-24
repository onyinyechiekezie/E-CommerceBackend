package com.ecommerce.ecommercebackend.domain.exception;

public class InvalidProfileException extends RuntimeException {
    public InvalidProfileException(String message) {
        super(message);
    }
}
