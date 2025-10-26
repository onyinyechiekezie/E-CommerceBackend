package com.ecommerce.ecommercebackend.application.dto.request;

import com.ecommerce.ecommercebackend.domain.enums.Role;

public record UserRegistrationRequest(
        String name,
        String email,
        String password,
        Role role
) {


}
