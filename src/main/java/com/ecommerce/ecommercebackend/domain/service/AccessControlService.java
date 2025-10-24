package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.exception.UnauthorizedActionException;
import com.ecommerce.ecommercebackend.domain.enums.Role;

public class AccessControlService {
    public void ensureAdmin(Role role) {
        if (role != Role.ADMIN) throw new UnauthorizedActionException("Only admins can perform this action");
    }
}
