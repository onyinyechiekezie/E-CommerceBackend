package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.enums.PaymentStatus;
import com.ecommerce.ecommercebackend.domain.exception.InvalidPaymentAmountException;
import com.ecommerce.ecommercebackend.domain.model.Order;
import com.ecommerce.ecommercebackend.domain.model.Payment;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class PaymentDomainService {

    public Payment createPayment(Order order, BigDecimal amount) {
        if (order.getTotalAmount().compareTo(amount) != 0)
            throw new InvalidPaymentAmountException("Payment amount does not match order total");
        return new Payment(UUID.randomUUID(), order, amount, PaymentStatus.PENDING, LocalDateTime.now());
    }

    public Payment markPaymentAsSuccessful(Payment payment) {
        return new Payment(payment.getId(), payment.getOrder(), payment.getAmount(),
                PaymentStatus.PAID, payment.getPaidAt());
    }

    public Payment markPaymentAsFailed(Payment payment) {
        return new Payment(payment.getId(), payment.getOrder(), payment.getAmount(),
                PaymentStatus.FAILED, payment.getPaidAt());
    }
}
