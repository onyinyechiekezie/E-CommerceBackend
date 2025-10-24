package com.ecommerce.ecommercebackend.domain.model;

public class Permission {

    private final String action;
    private final String description;

    public Permission(String action, String description) {
        this.action = action;
        this.description = description;
    }

    public String getAction() { return action; }
    public String getDescription() { return description; }
}
