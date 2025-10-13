package com.ecommerce.ecommercebackend.domain.model;

import com.ecommerce.ecommercebackend.domain.enums.OrderStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {

    private final UUID id;
    private final User customer;
    private final List<OrderItem> items;
    private final BigDecimal totalAmount;
    private final OrderStatus status;
    private final LocalDateTime createdAt;

    public Order(UUID id, User customer, List<OrderItem> items, BigDecimal totalAmount,
                 OrderStatus status, LocalDateTime createdAt) {
        this.id = id;
        this.customer = customer;
        this.items = items;
        this.totalAmount = totalAmount;
        this.status = status;
        this.createdAt = createdAt;
    }

    public UUID getId() { return id; }
    public User getCustomer() { return customer; }
    public List<OrderItem> getItems() { return items; }
    public BigDecimal getTotalAmount() { return totalAmount; }
    public OrderStatus getStatus() { return status; }
    public LocalDateTime getCreatedAt() { return createdAt; }
}
