package com.elysian.springbootexercise.repository;

import com.elysian.springbootexercise.database.InitSections;
import com.elysian.springbootexercise.database.InitStores;
import com.elysian.springbootexercise.model.Section;
import com.elysian.springbootexercise.model.Store;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class StoreRepository {

	private final List<Store> stores = new ArrayList<>(InitStores.getStores());
	private final List<Section> sections = new ArrayList<>(InitSections.getSections());

	@Autowired
	public StoreRepository() {

	}

	public List<Store> getAllStores() {
		return stores;
	}

	public boolean addSectionToStore(int sectionId, int storeId) {
		try {
			stores.get(storeId).getSections().add(sections.get(sectionId));
			return true;
		} catch (Exception e) {
			// logging
			return false;
		}
	}
}