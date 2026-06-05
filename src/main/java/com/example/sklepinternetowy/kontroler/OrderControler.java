package com.example.sklepinternetowy.kontroler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
public class OrderControler {
    @GetMapping("/cart")
    public String showCart()
    {
        return "cartView";
    }
}
