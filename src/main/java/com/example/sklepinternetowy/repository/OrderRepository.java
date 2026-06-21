package com.example.sklepinternetowy.repository;

import com.example.sklepinternetowy.model.order.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
