package com.ecommerce.ecommercebackend.domain.model;

public class Address {
    private final String street;
    private final String city;
    private final String state;
    private final String country;
    private final String postalCode;
    private final boolean isDefault;

    public Address(String street, String city, String state, String country, String postalCode, boolean isDefault) {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.postalCode = postalCode;
        this.isDefault = isDefault;
    }

    public String getStreet() { return street; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getCountry() { return country; }
    public String getPostalCode() { return postalCode; }
    public boolean isDefault() { return isDefault; }
}
