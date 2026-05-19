package com.example.sklepinternetowy.model;
import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Item
{
	private String name;
	private String description;
	private BigDecimal price;
    private String imageURL;
}

