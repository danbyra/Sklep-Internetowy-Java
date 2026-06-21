package com.example.sklepinternetowy.services;

import com.example.sklepinternetowy.Cart;
import com.example.sklepinternetowy.ItemOperation;
import com.example.sklepinternetowy.model.Item;
import com.example.sklepinternetowy.repository.ItemRepository;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class CartService {
    private final ItemRepository itemRepository;
    @Getter
    private final Cart cart;

    public  CartService(ItemRepository item,Cart cart){
        this.itemRepository=item;
        this.cart=cart;
    }
    public void manageCart(long itemId, ItemOperation operation){
        Optional<Item> item=itemRepository.findById(itemId);
        if(item.isPresent()){
            switch(operation){
                case INCREASE ->  cart.addItem(item.get());
                case DECREASE -> cart.removeItem(item.get());
                case DELETE -> cart.removeItemCompletly(item.get());
            }
        }
    }
    //    public void addToCart(long itemId){
//        Optional<Item> item=itemRepository.findById(itemId);
//        item.ifPresent(cart::addItem);
//    }
//
//    public void removeFromCart(long itemId){
//        Optional<Item> item=itemRepository.findById(itemId);
//        item.ifPresent(cart::removeItem);
//    }
//    public void removeCompletlyFromCart(long itemId){
//        Optional<Item> item=itemRepository.findById(itemId);
//        item.ifPresent(cart::removeItemCompletly);
//    }

}
