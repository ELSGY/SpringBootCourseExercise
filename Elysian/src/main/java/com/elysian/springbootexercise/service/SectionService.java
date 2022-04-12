package com.elysian.springbootexercise.service;

import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.model.Section;
import com.elysian.springbootexercise.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SectionService {

	private final SectionRepository sectionRepository;

	@Autowired
	public SectionService(SectionRepository sectionRepository) {
		this.sectionRepository = sectionRepository;
	}

	public List<Section> getAllSections() {
		return sectionRepository.getAllSections();
	}

	public Section getSectionById(int id) {
		return sectionRepository.getSectionById(id);
	}

	public boolean addSection(Section section) {
		return sectionRepository.addSection(section);
	}

	public boolean deleteSection(int sectionId) {
		return sectionRepository.deleteSection(sectionId);
	}

	public boolean addProductToSection(int sectionId, Product product) {
		return sectionRepository.addProductToSection(sectionId, product);
	}
}
