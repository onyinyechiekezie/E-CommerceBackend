package com.ecommerce.ecommercebackend.domain.model;

import com.ecommerce.ecommercebackend.domain.enums.PaymentStatus;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {

    private final UUID id;
    private final Order order;
    private final BigDecimal amount;
    private final PaymentStatus status;
    private final LocalDateTime paidAt;

    public Payment(UUID id, Order order, BigDecimal amount, PaymentStatus status, LocalDateTime paidAt) {
        this.id = id;
        this.order = order;
        this.amount = amount;
        this.status = status;
        this.paidAt = paidAt;
    }

    public UUID getId() { return id; }
    public Order getOrder() { return order; }
    public BigDecimal getAmount() { return amount; }
    public PaymentStatus getStatus() { return status; }
    public LocalDateTime getPaidAt() { return paidAt; }
}
