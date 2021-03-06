package com.elysian.springbootexercise.controller;

import com.elysian.springbootexercise.service.StoreService;
import com.elysian.springbootexercise.utils.annotations.HasAdminRole;
import com.elysian.springbootexercise.utils.annotations.HasUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/store")
public class StoreController {

	private final StoreService storeService;

	@Autowired
	public StoreController(StoreService storeService) {
		this.storeService = storeService;
	}

	@HasUserRole
	@HasAdminRole
	@GetMapping("/getAllStores")
	public String getAllProducts() {
		return storeService.getAllStores().toString();
	}

	@HasAdminRole
	@GetMapping("/{sectiondId}/{storeId}")
	public String addSectionToStore(@PathVariable int sectiondId, @PathVariable int storeId) {
		if (storeService.addSectionToStore(sectiondId, storeId))
			return "Section added to store";
		return "Section could not be added to store";
	}

}
