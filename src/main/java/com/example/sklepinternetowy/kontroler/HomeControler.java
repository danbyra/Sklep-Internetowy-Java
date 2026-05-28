package com.example.sklepinternetowy.kontroler;

import com.example.sklepinternetowy.model.Item;
import com.example.sklepinternetowy.repository.ItemRepository;
import jakarta.servlet.http.HttpSession;
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
    @GetMapping("/add/{itemId}")
    public String addItemToCart(@PathVariable("itemId") long itemId,HttpSession session)
    {
        List<Item> items = itemRepository.findAll();
        @SuppressWarnings("unchecked")
        List<Item> carts=(List<Item>)session.getAttribute("cart");

        if(carts==null)carts=new ArrayList<>();

        Optional<Item> item=itemRepository.findById(itemId);
        if(item.isPresent())
        {
            carts.add(item.get());
            session.setAttribute("cart",carts);
        }
        BigDecimal total=BigDecimal.ZERO;
        for(Item i:carts)
        {
            total=total.add(i.getPrice());
        }
        session.setAttribute("total",total);
        return "redirect:/";
    }
    @GetMapping("/cart")
    public String cartView()
    {
        return "cartView";

    }

}
