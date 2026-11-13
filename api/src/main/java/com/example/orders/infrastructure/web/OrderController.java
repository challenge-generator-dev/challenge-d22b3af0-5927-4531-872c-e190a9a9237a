package com.example.orders.infrastructure.web;

import com.example.orders.application.OrderService;
import com.example.orders.application.OrderService.CreateOrderRequest;
import com.example.orders.application.OrderService.OrderItemRequest;
import com.example.orders.domain.Order;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@Valid @RequestBody CreateOrderRequest request) {
        Order order = orderService.createOrder(request);
        OrderResponse response = mapToOrderResponse(order);
        return ResponseEntity.created(URI.create("/api/orders/" + order.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderResponse> getOrder(@PathVariable String id) {
        return orderService.getOrder(id)
                .map(this::mapToOrderResponse)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    private OrderResponse mapToOrderResponse(Order order) {
        List<OrderItemResponse> items = order.getItems().stream()
                .map(item -> new OrderItemResponse(
                        item.getProductId(),
                        item.getQuantity(),
                        item.getPrice()
                ))
                .collect(Collectors.toList());

        return new OrderResponse(
                order.getId(),
                items,
                order.getCustomerId(),
                order.getStatus().name(),
                order.getCreatedAt().toString()
        );
    }

    public record OrderItemResponse(String productId, int quantity, double price) {}

    public record OrderResponse(
            String id,
            List<OrderItemResponse> items,
            String customerId,
            String status,
            String createdAt
    ) {}
}