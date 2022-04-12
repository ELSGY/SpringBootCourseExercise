package com.elysian.springbootexercise.model;

import com.elysian.springbootexercise.utils.annotations.ExcludeFieldFromJson;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

public class Store extends AbstractEntity {

	@Getter
	@Setter
	private int id;

	@Getter
	@Setter
	private String name;

	@Getter
	@Setter
	private String location;

	@Getter
	@Setter
	@ExcludeFieldFromJson // maybe added, maybe not while creating a Store object
	private Set<Section> sections;

	public Store() {

	}

	public Store(final int id, final String name, String location) {
		this.id = id;
		this.name = name;
		this.location = location;
	}

	public Store(final int id, final String name, String location, Set<Section> sections) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.sections.addAll(sections);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Store store))
			return false;
		return id == store.id &&
			   Objects.equals(name, store.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name);
	}
}
