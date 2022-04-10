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
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import java.util.Objects;
import java.util.Set;

public class Section extends AbstractEntity {

	@Getter
	@Setter
	@Id
	@Column(name = "id")
	@GeneratedValue(generator = "section_sequence_generator")
	@SequenceGenerator(name = "section_sequence_generator", sequenceName = "section_sequence", allocationSize = 1)
	private int id;

	@Getter
	@Setter
	@Column(name = "name", length = 40)
	private String name;

	@Getter
	@Setter
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "storeId")
	@JsonIgnore
	private Store store;

	@Getter
	@Setter
	@OneToMany(mappedBy = "section", cascade = CascadeType.ALL, orphanRemoval = true)
	@OrderBy(value = "name")
	private Set<Product> products;

	public Section() {

	}

	public Section(final String name) {
		this.name = name;
	}

	public Section(final int id, final String name) {
		this.id = id;
		this.name = name;
	}

	public Section(final String name, final Set<Product> products) {
		this.name = name;
		this.products.addAll(products);
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
}
