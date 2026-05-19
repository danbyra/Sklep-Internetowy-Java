package com.example.sklepinternetowy.kontroler;

import com.example.sklepinternetowy.model.Item;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControler
{
    @GetMapping
    public String adminPage()
    {
        return "adminView/addItem.html";
    }
    @PostMapping
    private String addItem(Item item)
    {
        HomeControler.items.add(item);
        return "redirect:/";
    }
}
