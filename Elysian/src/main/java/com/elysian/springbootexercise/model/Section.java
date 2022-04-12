package com.elysian.springbootexercise.model;

import com.elysian.springbootexercise.utils.annotations.ExcludeFieldFromJson;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

public class Section extends AbstractEntity {

	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	@ExcludeFieldFromJson // maybe added, maybe not while creating a Section object
	private Store store;

	@Getter
	@Setter
	@ExcludeFieldFromJson // maybe added, maybe not while creating a Section object
	private Set<Product> products;

	public Section() {

	}

	public Section(final int id, final String name) {
		this.id = id;
		this.name = name;
	}

	public Section(final int id, final String name, final Set<Product> products) {
		this.id = id;
		this.name = name;
		this.products = products;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Section that))
			return false;
		return id == that.id &&
			   Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}

	@Override
	public String toString() {
		return id + ", " + name;
	}
}
