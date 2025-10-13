package com.ecommerce.ecommercebackend.domain.model;

import java.math.BigDecimal;
import java.util.UUID;

public class OrderItem {

    private final UUID id;
    private final Product product;
    private final int quantity;
    private final BigDecimal unitPrice;

    public OrderItem(UUID id, Product product, int quantity, BigDecimal unitPrice) {
        this.id = id;
        this.product = product;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
    }

    public UUID getId() { return id; }
    public Product getProduct() { return product; }
    public int getQuantity() { return quantity; }
    public BigDecimal getUnitPrice() { return unitPrice; }
}
