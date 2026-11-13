package com.example.orders.application;

import com.example.orders.domain.Order;
import com.example.orders.domain.OrderRepository;
import com.example.orders.domain.OrderItem;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order createOrder(@Valid CreateOrderRequest request) {
        List<OrderItem> items = request.items().stream()
                .map(item -> new OrderItem(item.productId(), item.quantity(), item.price()))
                .toList();

        Order order = new Order(request.customerId(), items);
        return orderRepository.save(order);
    }

    public Optional<Order> getOrder(String id) {
        return orderRepository.findById(id);
    }

    public record CreateOrderRequest(
            @Valid List<OrderItemRequest> items,
            @Valid String customerId) {
    }

    public record OrderItemRequest(
            @Valid String productId,
            @Valid int quantity,
            @Valid double price) {
    }
}