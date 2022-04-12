package com.elysian.springbootexercise.service;

import com.elysian.springbootexercise.model.Store;
import com.elysian.springbootexercise.repository.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

	private final StoreRepository storeRepository;

	@Autowired
	public StoreService(StoreRepository storeRepository) {
		this.storeRepository = storeRepository;
	}

	public List<Store> getAllStores() {
		return storeRepository.getAllStores();
	}

	public boolean addSectionToStore(int sectionId, int storeId) {
		return storeRepository.addSectionToStore(sectionId, storeId);
	}
}
