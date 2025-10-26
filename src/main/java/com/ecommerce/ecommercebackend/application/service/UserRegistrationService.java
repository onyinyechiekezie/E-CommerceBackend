package com.ecommerce.ecommercebackend.application.service;

import com.ecommerce.ecommercebackend.application.dto.request.UserRegistrationRequest;
import com.ecommerce.ecommercebackend.application.dto.response.UserResponse;
import com.ecommerce.ecommercebackend.application.ports.input.UserRegistrationUseCase;
import com.ecommerce.ecommercebackend.application.ports.output.UserRepositoryPort;
import com.ecommerce.ecommercebackend.domain.model.User;
import com.ecommerce.ecommercebackend.domain.service.UserDomainService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRegistrationService implements UserRegistrationUseCase {
    private final UserDomainService userDomainService;
    private final UserRepositoryPort userRepositoryPort;

    public UserRegistrationService(UserDomainService userDomainService, UserRepositoryPort userRepositoryPort) {
        this.userDomainService = userDomainService;
        this.userRepositoryPort = userRepositoryPort;
    }

    @Override
    public UserResponse registerUser(UserRegistrationRequest request) {
        List<User> existingUsers = userRepositoryPort.findByEmail(request.email())
                .map(List::of)
                .orElse(List.of());

        User newUser = userDomainService.createUser(
                request.name(),
                request.email(),
                request.password(),
                request.role(),
                existingUsers
        );

        User savedUser = userRepositoryPort.save(newUser);

        return new UserResponse(
                savedUser.getId(),
                savedUser.getName(),
                savedUser.getEmail(),
                savedUser.getRole(),
                savedUser.isActive()
        );
    }
}
