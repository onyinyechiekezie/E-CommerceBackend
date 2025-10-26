package com.ecommerce.ecommercebackend.application.dto.response;

import com.ecommerce.ecommercebackend.domain.enums.Role;

import java.util.UUID;

public record UserResponse(UUID id,
                           String name,
                           String email,
                           Role role,
                           boolean active) {
}
