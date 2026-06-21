package com.example.sklepinternetowy.model.order;

import com.example.sklepinternetowy.model.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_item_id")
    private long idOrderItem;

    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    @JsonIgnore
    private Order order;

//    public OrderItem(long idOrder,long idItem, int quantity) {
//        this.idOrder = idOrder;
//        this.idItem = idItem;
//        this.quantity = quantity;
    public OrderItem(Item item,int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

}
