package com.elysian.springbootexercise.model;

import com.elysian.springbootexercise.utils.annotations.ExcludeFieldFromJson;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Product extends AbstractEntity {

	@Getter
	@Setter
	private long id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private double price;

	@Getter
	@Setter
	@ExcludeFieldFromJson //maybe added, maybe not while creating a Product object
	private Section section;

	public Product() {
	}

	public Product(final int id, final String name, final double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public Product(final int id, final String name, final double price, final Section section) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.section = section;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Product product))
			return false;
		return id == product.id &&
			   Objects.equals(name, product.name) &&
			   Objects.equals(price, product.price) &&
			   Objects.equals(section, product.section);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, section);
	}

	@Override
	public String toString() {
		return "\n" + id + ", " + name + " [" + price + "]";
	}
}
