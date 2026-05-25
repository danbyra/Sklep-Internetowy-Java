package com.example.sklepinternetowy.kontroler;

import com.example.sklepinternetowy.model.Item;
import com.example.sklepinternetowy.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminControler
{
    private final ItemRepository itemRepository;
    @Autowired
    public AdminControler(ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }

    @GetMapping
    public String adminPage()
    {
        return "adminView/addItem.html";
    }
    @PostMapping
    public String addItem(Item item)
    {

        itemRepository.save(item);
        return "redirect:/";
    }
}
