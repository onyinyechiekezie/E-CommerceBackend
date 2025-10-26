package com.ecommerce.ecommercebackend.application.ports.input;

import com.ecommerce.ecommercebackend.application.dto.request.UserRegistrationRequest;
import com.ecommerce.ecommercebackend.application.dto.response.UserResponse;


public interface UserRegistrationUseCase {

    UserResponse registerUser(UserRegistrationRequest request);


}
