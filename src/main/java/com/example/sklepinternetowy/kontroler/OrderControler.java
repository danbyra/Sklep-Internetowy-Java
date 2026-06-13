package com.example.sklepinternetowy.kontroler;

import com.example.sklepinternetowy.ItemOperation;
import com.example.sklepinternetowy.services.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderControler {

    private final CartService cartService;
    public OrderControler(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String showCart() {
        return "cartView";
    }

    @GetMapping("/cart/increase/{itemId}")
    public String increaseCart(@PathVariable("itemId") long itemId){
        cartService.manageCart(itemId, ItemOperation.INCREASE);
        return "redirect:/order/cart";
    }

    @GetMapping("/cart/decrease/{itemId}")
    public String decreaseCart(@PathVariable("itemId") long itemId){
        cartService.manageCart(itemId, ItemOperation.DECREASE);
        return "redirect:/order/cart";
    }

    @GetMapping("/cart/remove/{itemId}")
    public String removeCart(@PathVariable("itemId") long itemId) {
        cartService.manageCart(itemId,ItemOperation.DELETE);
        return "redirect:/order/cart";
    }
}
