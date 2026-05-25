package com.example.sklepinternetowy.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Item
{
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String description;
	private BigDecimal price;
    private String imageURL;

	public Item(String name, String description, BigDecimal price, String imageURL) {
		this.name = name;
		this.description = description;
		this.price = price;
		this.imageURL = imageURL;
	}
}

