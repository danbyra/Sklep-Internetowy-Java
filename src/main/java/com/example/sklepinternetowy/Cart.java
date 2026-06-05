package com.example.sklepinternetowy;

import com.example.sklepinternetowy.model.Item;
import lombok.Getter;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Scope(value = "session",proxyMode = ScopedProxyMode.TARGET_CLASS)
@Getter
public class Cart {
    private List<CartItem>cartItems=new ArrayList<>();
    private int counter;
    private BigDecimal sum=BigDecimal.ZERO;

    private Optional<CartItem>findCartItemByItem(Item item)
    {
        return cartItems.stream()
                .filter(cartItem -> cartItem.isEquals(item))
                .findFirst();
    }
    private void recarecalculatePriceAndCounter(){
//        int totalCounter=0;
//        BigDecimal totalPriceSum=BigDecimal.ZERO;
//
//        for(CartItem cartItem:cartItems){
//            totalCounter+=cartItem.getCounter();
//            totalPriceSum=totalPriceSum.add(cartItem.getPrice());
//        }
//        this.counter=totalCounter;
//        this.sum=totalPriceSum;
        this.counter=cartItems.stream()
                .map(CartItem::getCounter)
                .reduce(0,Integer::sum);
        this.sum=cartItems.stream()
                .map(CartItem::getPrice)
                .reduce(BigDecimal.ZERO,BigDecimal::add);
    }
    public void addItem(Item item) {
//        boolean existItem=false;
//        for(CartItem cartItem:cartItems){
//            if(cartItem.getItem().getId().equals(item.getId())){
//                cartItem.increaseCounter();
//                existItem=true;
//                break;
//            }
//        }
//        if(!existItem){
//            cartItems.add(new CartItem(item));
//        }
        findCartItemByItem(item).ifPresentOrElse(
                CartItem::increaseCounter,
                ()->cartItems.add(new CartItem(item))
        );
        recarecalculatePriceAndCounter();
    }

    public void removeItem(Item item) {
//        CartItem cartItemRemove=null;
//        for(CartItem cartItem:cartItems){
//            if(cartItem.getItem().getId().equals(item.getId())){
//                cartItem.decreaseCounter();
//            }
//            if(cartItem.hasZeroItems()){
//                cartItemRemove=cartItem;
//            }
//            break;
//        }
        findCartItemByItem(item).ifPresent(ci->{
            ci.decreaseCounter();
            if(ci.hasZeroItems())
            {
                cartItems.remove(ci);
            }
        });
        recarecalculatePriceAndCounter();
    }
}
