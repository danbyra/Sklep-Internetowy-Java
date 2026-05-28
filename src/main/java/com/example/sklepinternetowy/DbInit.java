package com.example.sklepinternetowy;

import com.example.sklepinternetowy.model.Item;
import com.example.sklepinternetowy.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;
import java.util.List;

@Configuration
public class DbInit implements CommandLineRunner
{
    private final ItemRepository itemRepository;
    @Autowired
    public DbInit(ItemRepository itemRepository)
    {
        this.itemRepository = itemRepository;
    }
    @Override
    public void run(String... args) throws Exception
    {
        if(itemRepository.count()==0)
        {
            itemRepository.saveAll(List.of(
                    new Item("Zegarek","opis zegarka",new BigDecimal("2500.0"),
                            "https://s1.apart.pl/products/watches/packshot/13840/apart-fc-335mcgrw4p26--0.jpg"),
                    new Item("Zegarek1","opis zegarka1",new BigDecimal("3500.0"),
                            "https://s1.apart.pl/products/watches/packshot/13840/apart-fc-335mcgrw4p26--0.jpg")

            ));
        }

    }
}
