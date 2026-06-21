package com.example.sklepinternetowy.kontroler;

import com.example.sklepinternetowy.dto.OrderDto;
import com.example.sklepinternetowy.services.CartService;
import com.example.sklepinternetowy.services.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/order")
@RequiredArgsConstructor
public class SummaryControler {

    private final CartService cartService;
    private final OrderService orderService;
    @GetMapping("/summary")
    public String showSummary(Model model)
    {
        model.addAttribute("cart",cartService.getCart());
        return "summary";
    }
    @PostMapping("/saveorder")
    public String saveOrder(OrderDto  orderDto) {
        orderService.saveOrder(orderDto);
        return "redirect:/order/confirmation";
    }

    @GetMapping("/confirmation")
    public String showConfirmation() {
        return "confirmation";
    }
}
