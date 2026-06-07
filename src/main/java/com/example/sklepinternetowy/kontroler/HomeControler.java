package com.example.sklepinternetowy.kontroler;

import com.example.sklepinternetowy.Cart;
import com.example.sklepinternetowy.model.Item;
import com.example.sklepinternetowy.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeControler
{
    private final ItemRepository itemRepository;
    private final Cart cart;
    @Autowired
    public HomeControler(ItemRepository itemRepository,Cart cart) {
        this.itemRepository = itemRepository;
        this.cart = cart;
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
        Optional<Item> itemOptional=itemRepository.findById(itemId);

        if(itemOptional.isPresent()) {
            Item item=itemOptional.get();
            cart.addItem(item);
        }
        return "redirect:/";
    }
    @GetMapping("/cart")
    public String cartView() {
        return "cartView";

    }

}
