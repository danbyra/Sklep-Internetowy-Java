package com.example.sklepinternetowy.kontroler;

import com.example.sklepinternetowy.ItemOperation;
import com.example.sklepinternetowy.model.Item;
import com.example.sklepinternetowy.repository.ItemRepository;
import com.example.sklepinternetowy.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class HomeControler
{
    private final ItemRepository itemRepository;
    private final CartService cartService;
    @Autowired
    public HomeControler(ItemRepository itemRepository, CartService cartService) {
        this.itemRepository = itemRepository;
        this.cartService = cartService;
    }
    @GetMapping("/")
    //@ResponseBody
        public String home(Model model) {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "home";
    }
    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") long itemId) {
        cartService.manageCart(itemId, ItemOperation.INCREASE);
        return "redirect:/";
    }
    @GetMapping("/cart")
    public String cartView() {
        return "cartView";

    }

}
