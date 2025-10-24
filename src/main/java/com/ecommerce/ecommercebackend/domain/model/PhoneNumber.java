package com.ecommerce.ecommercebackend.domain.model;

public class PhoneNumber {
    private final String number;
    private final boolean verified;

    public PhoneNumber(String number, boolean verified) {
        this.number = number;
        this.verified = verified;
    }

    public String getNumber() { return number; }
    public boolean isVerified() { return verified; }
}
