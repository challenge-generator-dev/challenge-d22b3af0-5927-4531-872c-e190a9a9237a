package com.example.orders.infrastructure.persistence;

import com.example.orders.domain.OrderItem;
import jakarta.persistence.*;

@Entity
@Table(name = "order_items")
public class OrderItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String productId;

    @Column(nullable = false)
    private int quantity;

    @Column(nullable = false)
    private double price;

    protected OrderItemEntity() {
    }

    public OrderItemEntity(OrderItem orderItem) {
        this.productId = orderItem.getProductId();
        this.quantity = orderItem.getQuantity();
        this.price = orderItem.getPrice();
    }

    public OrderItem toDomain() {
        return new OrderItem(productId, quantity, price);
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }
}