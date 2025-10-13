package com.ecommerce.ecommercebackend.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class Product {

    private final UUID id;
    private String name;
    private String description;
    private BigDecimal price;
    private int stockQuantity;
    private Category category;

    public Product(UUID id, String name, String description, BigDecimal price, int stockQuantity, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.category = category;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public BigDecimal getPrice() { return price; }
    public int getStockQuantity() { return stockQuantity; }
    public Category getCategory() { return category; }
}
