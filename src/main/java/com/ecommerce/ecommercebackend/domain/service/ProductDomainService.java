package com.ecommerce.ecommercebackend.domain.service;

import com.ecommerce.ecommercebackend.domain.model.Product;
import java.math.BigDecimal;
import java.util.UUID;

public class ProductDomainService {

    public Product createProduct(String name, String description, BigDecimal price, int stockQuantity,
                                 com.ecommerce.ecommercebackend.domain.model.Category category) {
        return new Product(UUID.randomUUID(), name, description, price, stockQuantity, category);
    }

    public boolean hasSufficientStock(Product product, int quantity) {
        return product.getStockQuantity() >= quantity;
    }

    public Product reduceStock(Product product, int quantity) {
        int newStock = product.getStockQuantity() - quantity;
        if (newStock < 0) throw new IllegalStateException("Insufficient stock for product: " + product.getName());
        return new Product(product.getId(), product.getName(), product.getDescription(),
                product.getPrice(), newStock, product.getCategory());
    }
}
