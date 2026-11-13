package com.example.orders.infrastructure.persistence;

import com.example.orders.domain.Order;
import com.example.orders.domain.OrderRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository orderJpaRepository;

    public OrderRepositoryImpl(OrderJpaRepository orderJpaRepository) {
        this.orderJpaRepository = orderJpaRepository;
    }

    @Override
    public Order save(Order order) {
        OrderEntity entity = new OrderEntity(order);
        OrderEntity savedEntity = orderJpaRepository.save(entity);
        return savedEntity.toDomain();
    }

    @Override
    public Optional<Order> findById(String id) {
        return orderJpaRepository.findById(id)
                .map(OrderEntity::toDomain);
    }
}