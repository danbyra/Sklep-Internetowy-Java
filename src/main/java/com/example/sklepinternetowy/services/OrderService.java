package com.example.sklepinternetowy.services;

import com.example.sklepinternetowy.Cart;
import com.example.sklepinternetowy.dto.OrderDto;
import com.example.sklepinternetowy.mapper.OrderMapper;
import com.example.sklepinternetowy.model.order.Order;
import com.example.sklepinternetowy.repository.OrderItemRepository;
import com.example.sklepinternetowy.repository.OrderRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final Cart cart;
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    @Transactional
    public void saveOrder(OrderDto orderDto) {
        Order order = OrderMapper.mapToOrder(orderDto, cart);
        orderRepository.save(order);

        cart.clearCart();
    }
}
