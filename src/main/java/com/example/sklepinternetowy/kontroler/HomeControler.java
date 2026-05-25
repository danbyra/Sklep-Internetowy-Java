package com.example.sklepinternetowy.kontroler;

import com.example.sklepinternetowy.model.Item;
import com.example.sklepinternetowy.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeControler
{
    private final ItemRepository itemRepository;
    @Autowired
    public HomeControler(ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/")
    //@ResponseBody
        public String home(Model model)
    {
        List<Item> items = itemRepository.findAll();
        model.addAttribute("items",items);
        return "home";
    }


    @GetMapping("/cartView.html")
    public String cartView()
    {
        return "cartView";
    }

}
