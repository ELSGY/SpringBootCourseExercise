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

	public Product() {
	}

	public Product(String name) {
		this.name = name;
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
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Product product))
			return false;
		return id == product.id &&
			   Objects.equals(name, product.name) &&
			   Objects.equals(price, product.price);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price);
	}

	@Override
	public String toString() {
		return "\n" + id + ", " + name + " [" + price + "]";
	}
}
