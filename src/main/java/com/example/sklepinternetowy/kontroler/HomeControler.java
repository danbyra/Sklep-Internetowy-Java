package com.example.sklepinternetowy.kontroler;

import com.example.sklepinternetowy.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeControler
{
    static List<Item> items=new ArrayList<>();
    static {
            items.add( new Item("Zegarek","test opisu",new BigDecimal("2500"),
                    "https://s1.apart.pl/products/watches/packshot/13840/apart-fc-335mcgrw4p26--0.jpg"));
            items.add( new Item("Zegarek","test opisu",new BigDecimal("2500"),
                    "https://s1.apart.pl/products/watches/packshot/13840/apart-fc-335mcgrw4p26--0.jpg"));
            items.add( new Item("Zegarek","test opisu",new BigDecimal("2500"),
                    "https://s1.apart.pl/products/watches/packshot/13840/apart-fc-335mcgrw4p26--0.jpg"));
            items.add( new Item("Zegarek","test opisu",new BigDecimal("2500"),
                    "https://s1.apart.pl/products/watches/packshot/13840/apart-fc-335mcgrw4p26--0.jpg"));
    }
    @GetMapping("/")
    //@ResponseBody
        public String home(Model model)
    {
        model.addAttribute("items",items);
        return "home";
    }


    @GetMapping("/cartView.html")
    public String cartView()
    {
        return "cartView";
    }

}
