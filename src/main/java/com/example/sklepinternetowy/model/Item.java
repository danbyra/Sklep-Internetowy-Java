package com.example.sklepinternetowy.model;

import jakarta.persistence.*;
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
@Table(name ="item")
public class Item
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "ID")
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

