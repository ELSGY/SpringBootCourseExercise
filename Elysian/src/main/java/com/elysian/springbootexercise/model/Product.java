package com.elysian.springbootexercise.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import java.util.Objects;

public class Product extends AbstractEntity {

	@Getter
	@Setter
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "product_sequence_generator")
	@SequenceGenerator(name = "product_sequence_generator", sequenceName = "product_sequence", allocationSize = 1)
	private long id;

	@Getter
	@Setter
	@Column(name = "name", unique = true, nullable = false, insertable = true, updatable = false, length = 50)
	private String name;

	@Getter
	@Setter
	@Column(name = "price", unique = false, nullable = false, insertable = true, updatable = true, length = 10)
	private double price;

	@Getter
	@Setter
	@ManyToOne(targetEntity = Section.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "sectionId")
	@JsonIgnore
	private Section section;

	public Product() {
	}

	public Product(final String name) {
		this.name = name;
	}

	public Product(final int id, final String name) {
		this.id = id;
		this.name = name;
	}

	public Product(final String name, final Section section) {
		this.name = name;
		this.section = section;
	}

	public Product(final String name, final double price) {
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
			   Objects.equals(price, product.price) &&
			   Objects.equals(section, product.section);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, price, section);
	}

	@Override
	public String toString() {
		return id + ", " + name + " [" + price + "]";
	}
}
