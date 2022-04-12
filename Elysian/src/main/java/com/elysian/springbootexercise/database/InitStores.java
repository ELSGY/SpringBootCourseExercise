package com.elysian.springbootexercise.database;

import com.elysian.springbootexercise.model.Store;

import java.util.HashSet;
import java.util.Set;

public final class InitStores {

	private static final Set<Store> stores;

	static {
		stores = setUpStores();
	}

	// ######################### STORE ########################
	private static Set<Store> setUpStores() {
		Set<Store> stores = new HashSet<>();
		stores.add(new Store(1, "MotoShop", "Arad", InitSections.getSections()));
		return stores;
	}

	public static Set<Store> getStores() {
		return stores;
	}

}
