package com.example.orders.infrastructure.persistence;

import com.example.orders.domain.Order;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "orders")
public class OrderEntity {
    @Id
    private String id;

    @Column(nullable = false)
    private String customerId;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "order_id")
    private List<OrderItemEntity> items;

    @Enumerated(EnumType.STRING)
    private Order.OrderStatus status;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    protected OrderEntity() {
    }

    public OrderEntity(Order order) {
        this.id = order.getId();
        this.customerId = order.getCustomerId();
        this.items = order.getItems().stream()
                .map(OrderItemEntity::new)
                .collect(Collectors.toList());
        this.status = order.getStatus();
        this.createdAt = order.getCreatedAt();
    }

    public Order toDomain() {
        return new Order(
                id,
                customerId,
                items.stream()
                        .map(OrderItemEntity::toDomain)
                        .collect(Collectors.toList()),
                status,
                createdAt
        );
    }

    public String getId() {
        return id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public List<OrderItemEntity> getItems() {
        return items;
    }

    public Order.OrderStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}