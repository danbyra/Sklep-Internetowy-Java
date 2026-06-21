package com.example.sklepinternetowy.repository;

import com.example.sklepinternetowy.model.order.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
