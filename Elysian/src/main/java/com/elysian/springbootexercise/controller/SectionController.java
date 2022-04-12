package com.elysian.springbootexercise.controller;

import com.elysian.springbootexercise.model.Section;
import com.elysian.springbootexercise.service.SectionService;
import com.elysian.springbootexercise.utils.annotations.HasAdminRole;
import com.elysian.springbootexercise.utils.annotations.HasUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/section")
public class SectionController {

	private final SectionService sectionService;

	public SectionController(SectionService sectionService) {
		this.sectionService = sectionService;
	}

	@HasUserRole
	@HasAdminRole
	@GetMapping("/getAllSections")
	public String getAllProducts() {
		return sectionService.getAllSections().toString();
	}

	@HasAdminRole
	@DeleteMapping("/{sectionId}")
	public String deleteProduct(@PathVariable int sectionId) {
		if (sectionService.deleteSection(sectionId))
			return "Section deleted!";
		return "Section couldn't be deleted!";
	}

	@HasAdminRole
	@PostMapping
	public String addSection(@RequestBody Section section) {
		if (sectionService.addSection(section))
			return "Section added!";
		return "Section couldn't be added";
	}

	@HasUserRole
	@HasAdminRole
	@GetMapping("/{id}")
	public String getAllProducts(@PathVariable int id) {
		return sectionService.getSectionById(id).toString();
	}
}
