package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.exception.InvalidProfileException;
import com.ecommerce.ecommercebackend.domain.model.Address;
import com.ecommerce.ecommercebackend.domain.model.PhoneNumber;
import com.ecommerce.ecommercebackend.domain.model.UserProfile;

import java.util.ArrayList;
import java.util.List;

public class UserProfileDomainService {

    public void validateProfile(UserProfile profile) {
        if (profile.getFirstName() == null || profile.getLastName() == null)
            throw new InvalidProfileException("Profile must have first and last name");

        if (profile.getAddresses() == null || profile.getAddresses().isEmpty())
            throw new InvalidProfileException("At least one address is required");

        if (profile.getPhoneNumbers() == null || profile.getPhoneNumbers().isEmpty())
            throw new InvalidProfileException("At least one phone number is required");
    }

    public UserProfile addAddress(UserProfile profile, Address address) {
        List<Address> updated = new ArrayList<>(profile.getAddresses());
        updated.add(address);
        return new UserProfile(profile.getUserId(), profile.getFirstName(), profile.getLastName(),
                profile.getGender(), profile.getDateOfBirth(), updated, profile.getPhoneNumbers());
    }

    public UserProfile addPhone(UserProfile profile, PhoneNumber phone) {
        List<PhoneNumber> updated = new ArrayList<>(profile.getPhoneNumbers());
        updated.add(phone);
        return new UserProfile(profile.getUserId(), profile.getFirstName(), profile.getLastName(),
                profile.getGender(), profile.getDateOfBirth(), profile.getAddresses(), updated);
    }

    public boolean isProfileComplete(UserProfile profile) {
        return profile.getFirstName() != null &&
                profile.getLastName() != null &&
                profile.getAddresses() != null &&
                !profile.getAddresses().isEmpty() &&
                profile.getPhoneNumbers() != null &&
                !profile.getPhoneNumbers().isEmpty();
    }
}
