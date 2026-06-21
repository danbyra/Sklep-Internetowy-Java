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
                    new Item("Frederique Constant Classics Moonphase Date",
                            "Frederique Constant Classics to kwintesencja ponadczasowej elegancji i wyrafinowanego zegarmistrzostwa.",
                            new BigDecimal("8990"),
                            "https://s1.apart.pl/products/watches/packshot/13840/apart-fc-335mcgrw4p26--0.jpg"),
                    new Item("Patek Philippe Nautilus Ref. 5711/1A-010",
                            "To jeden z najbardziej pożądanych i niedostępnych zegarków na ziemi.",
                            new BigDecimal("480000"),
                            "https://www.blackvenomwatch.com/upload/images/standardedition/patek/nautilus/patek_nautilus_5711-bianco.png"),
                    new Item("ROLEX SUBMARINER DATE STEEL BLACK DIAL REF. 126610LN FULL SET",
                            "To najbardziej znany zegarek sportowy na świecie.",
                            new BigDecimal("47000"),
                            "https://chroneo.pl/cdn/shop/files/Patek-4.jpg?v=1777454816&width=1200")

            ));
        }

    }
}
