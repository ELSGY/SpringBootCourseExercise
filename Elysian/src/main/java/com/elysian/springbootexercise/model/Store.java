package com.elysian.springbootexercise.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import java.util.Objects;
import java.util.Set;

public class Store extends AbstractEntity {

	@Getter
	@Setter
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "store_sequence_generator")
	@SequenceGenerator(name = "store_sequence_generator", sequenceName = "store_sequence", allocationSize = 1)
	private int id;

	@Getter
	@Setter
	@Column(nullable = false, length = 50, insertable = true)
	private String name;

	@Getter
	@Setter
	@Column(nullable = false, length = 50, insertable = true)
	private String location;

	@Getter
	@Setter
	@OneToMany(mappedBy = "store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Section> sections;

	public Store() {

	}

	public Store(final String name) {
		this.name = name;
	}

	public Store(final String name, String location) {
		this.name = name;
		this.location = location;
	}

	public Store(final String name, Set<Section> sections) {
		this.name = name;
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
