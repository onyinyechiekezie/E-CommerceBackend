package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.enums.OrderStatus;
import com.ecommerce.ecommercebackend.domain.model.Order;
import com.ecommerce.ecommercebackend.domain.model.OrderItem;
import com.ecommerce.ecommercebackend.domain.model.User;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class OrderDomainService {

    public Order createOrder(User customer, List<OrderItem> items) {
        BigDecimal total = calculateTotal(items);
        return new Order(UUID.randomUUID(), customer, items, total, OrderStatus.PENDING, LocalDateTime.now());
    }

    private BigDecimal calculateTotal(List<OrderItem> items) {
        return items.stream()
                .map(i -> i.getUnitPrice().multiply(BigDecimal.valueOf(i.getQuantity())))
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Order markAsCompleted(Order order) {
        return new Order(order.getId(), order.getCustomer(), order.getItems(), order.getTotalAmount(),
                OrderStatus.COMPLETED, order.getCreatedAt());
    }

    public Order cancelOrder(Order order) {
        return new Order(order.getId(), order.getCustomer(), order.getItems(), order.getTotalAmount(),
                OrderStatus.CANCELLED, order.getCreatedAt());
    }
}
