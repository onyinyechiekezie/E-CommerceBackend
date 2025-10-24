package com.ecommerce.ecommercebackend.domain.model;


import java.util.List;
import java.util.UUID;

public class UserProfile {
    private final UUID userId;
    private final String firstName;
    private final String lastName;
    private final String gender;
    private final String dateOfBirth;
    private final List<Address> addresses;
    private final List<PhoneNumber> phoneNumbers;

    public UserProfile(UUID userId, String firstName, String lastName, String gender, String dateOfBirth, List<Address> addresses, List<PhoneNumber> phoneNumbers) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.addresses = addresses;
        this.phoneNumbers = phoneNumbers;
    }

    public UUID getUserId() { return userId; }
    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getGender() { return gender; }
    public String getDateOfBirth() { return dateOfBirth; }
    public List<Address> getAddresses() { return addresses; }
    public List<PhoneNumber> getPhoneNumbers() { return phoneNumbers; }
}
