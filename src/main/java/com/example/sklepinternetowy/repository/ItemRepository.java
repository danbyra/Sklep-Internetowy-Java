package com.example.sklepinternetowy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.sklepinternetowy.model.Item;
public interface ItemRepository extends JpaRepository<Item, Long>
{

}
