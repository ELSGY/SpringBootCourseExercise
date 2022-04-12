package com.elysian.springbootexercise.repository;

import com.elysian.springbootexercise.database.InitSections;
import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SectionRepository {

	private final List<Section> sections = new ArrayList<>(InitSections.getSections());

	@Autowired
	public SectionRepository() {

	}

	public List<Section> getAllSections() {
		return sections;
	}

	public Section getSectionById(int id) {
		return sections.get(id);
	}

	public boolean addSection(Section section) {
		try {
			sections.add(section);
			return true;
		} catch (Exception e) {
			// logging
			return false;
		}
	}

	public boolean deleteSection(int sectionId) {
		try {
			sections.remove(sectionId);
			return true;
		} catch (Exception e) {
			// logging
			return false;
		}
	}

	public boolean addProductToSection(int sectionId, Product product) {
		try {
			sections.get(sectionId).getProducts().add(product);
			return true;
		} catch (Exception e) {
			// logging
			return false;
		}
	}

}