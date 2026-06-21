package com.example.sklepinternetowy.mapper;

import com.example.sklepinternetowy.Cart;
import com.example.sklepinternetowy.dto.OrderDto;
import com.example.sklepinternetowy.model.order.Order;
import com.example.sklepinternetowy.model.order.OrderItem;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderMapper {

    public static Order mapToOrder(OrderDto order, Cart cart)
    {
        Order builtOrder = Order.builder()
                .firstName(order.getFirstName())
                .lastName(order.getLastName())
                .email(order.getEmail())
                .zipCode(order.getZipCode())
                .city(order.getCity())
                .localDateTime(LocalDateTime.now())
                .build();

        List<OrderItem> orderItems = new ArrayList<>();
        cart.getCartItems().forEach(cartItem -> {
            OrderItem orderItem = new OrderItem(
                    cartItem.getItem(),
                    cartItem.getCounter()
            );
            orderItem.setOrder(builtOrder);
            orderItems.add(orderItem);
        });

        builtOrder.setOrderItems(orderItems);
        return builtOrder;
    }

//    public  static List<OrderItem>mapToOrderItemList(Cart cart, Order order) {
//        List<OrderItem> orderItems = new ArrayList<>();
//        cart.getCartItems().forEach(cartItem -> {
//           orderItems.add(new OrderItem(
//                   cartItem.getItem(),
//                   cartItem.getCounter()
//           ));
//        });
//        return orderItems;
//    }

}
