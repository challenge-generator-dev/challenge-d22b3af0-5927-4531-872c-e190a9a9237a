package com.example.orders.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class Order {
    private final String id;
    private final String customerId;
    private final List<OrderItem> items;
    private OrderStatus status;
    private final LocalDateTime createdAt;

    public Order(String customerId, List<OrderItem> items) {
        this.id = UUID.randomUUID().toString();
        this.customerId = validateCustomerId(customerId);
        this.items = validateItems(items);
        this.status = OrderStatus.CREATED;
        this.createdAt = LocalDateTime.now();
    }

    public Order(String id, String customerId, List<OrderItem> items, OrderStatus status, LocalDateTime createdAt) {
        this.id = validateId(id);
        this.customerId = validateCustomerId(customerId);
        this.items = validateItems(items);
        this.status = status;
        this.createdAt = createdAt;
    }

    private String validateId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Order ID cannot be null or empty");
        }
        return id;
    }

    private String validateCustomerId(String customerId) {
        if (customerId == null || customerId.trim().isEmpty()) {
            throw new IllegalArgumentException("Customer ID cannot be null or empty");
        }
        return customerId;
    }

    private List<OrderItem> validateItems(List<OrderItem> items) {
        if (items == null || items.isEmpty()) {
            throw new IllegalArgumentException("Order must contain at least one item");
        }
        items.forEach(item -> {
            if (item.getQuantity() <= 0) {
                throw new IllegalArgumentException("Item quantity must be positive");
            }
            if (item.getPrice() <= 0) {
                throw new IllegalArgumentException("Item price must be positive");
            }
        });
        return items;
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItem> getItems() {
        return List.copyOf(items);
    }

    public OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void markAsPaid() {
        this.status = OrderStatus.PAID;
    }

    public void markAsCancelled() {
        this.status = OrderStatus.CANCELLED;
    }

    public double calculateTotal() {
        return items.stream()
                .mapToDouble(item -> item.getPrice() * item.getQuantity())
                .sum();
    }

    public enum OrderStatus {
        CREATED, PAID, CANCELLED
    }
}