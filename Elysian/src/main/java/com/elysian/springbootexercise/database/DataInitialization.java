package com.elysian.springbootexercise.database;

import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.model.Section;
import com.elysian.springbootexercise.model.Store;

import java.util.HashSet;
import java.util.Set;

public final class DataInitialization {

	private static final Set<Product> products;
	private static final Set<Product> gloves;
	private static final Set<Product> helmets;
	private static final Set<Product> trousers;
	private static final Set<Product> boots;
	private static final Set<Section> sections;
	private static final Set<Store> stores;

	static {
		products = setUpProducts();
		gloves = setUpGloves();
		helmets = setUpHelmets();
		trousers = setUpTrousers();
		boots = setUpBoots();
		sections = setUpSections();
		stores = setUpStores();
	}

	// ######################### STORE ########################
	private static Set<Store> setUpStores() {
		Set<Store> stores = new HashSet<>();
		stores.add(new Store(1, "MotoShop", "Arad", getSections()));
		return stores;
	}

	public static Set<Store> getStores() {
		return stores;
	}

	// ######################### SECTIONS ########################
	private static Set<Section> setUpSections() {
		Set<Section> sections = new HashSet<>();
		sections.add(new Section(1, "Casti", getHelmets()));
		sections.add(new Section(2, "Manusi", getGloves()));
		sections.add(new Section(3, "Pantaloni", getTrousers()));
		sections.add(new Section(4, "Bocanci", getBoots()));
		return sections;
	}

	public static Set<Section> getSections() {
		return sections;
	}

	// ######################### PRODUCTS ########################
	private static Set<Product> setUpProducts() {
		Set<Product> products = new HashSet<>();
		products.add(new Product(1, "Casca1", 100));
		products.add(new Product(2, "Casca2", 200));
		products.add(new Product(3, "Casca3", 300));

		products.add(new Product(4, "Manusa1", 100));
		products.add(new Product(5, "Manusa2", 200));
		products.add(new Product(6, "Manusa3", 300));

		products.add(new Product(7, "Pantalon1", 100));
		products.add(new Product(8, "Pantalon2", 200));
		products.add(new Product(9, "Pantalon3", 300));

		products.add(new Product(10, "Bocanc1", 100));
		products.add(new Product(11, "Bocanc2", 200));
		products.add(new Product(12, "Bocanc3", 300));

		return products;
	}

	private static Set<Product> setUpHelmets() {
		Set<Product> products = new HashSet<>();
		products.add(new Product(1, "Casca1", 100));
		products.add(new Product(2, "Casca2", 200));
		products.add(new Product(3, "Casca3", 300));
		return products;
	}

	public static Set<Product> getHelmets() {
		return helmets;
	}

	private static Set<Product> setUpGloves() {
		Set<Product> products = new HashSet<>();
		products.add(new Product(4, "Manusa1", 100));
		products.add(new Product(5, "Manusa2", 200));
		products.add(new Product(6, "Manusa3", 300));
		return products;
	}

	public static Set<Product> getGloves() {
		return gloves;
	}

	private static Set<Product> setUpTrousers() {
		Set<Product> products = new HashSet<>();
		products.add(new Product(7, "Pantalon1", 100));
		products.add(new Product(8, "Pantalon2", 200));
		products.add(new Product(9, "Pantalon3", 300));
		return products;
	}

	public static Set<Product> getTrousers() {
		return trousers;
	}

	private static Set<Product> setUpBoots() {
		Set<Product> products = new HashSet<>();
		products.add(new Product(10, "Bocanc1", 100));
		products.add(new Product(11, "Bocanc2", 200));
		products.add(new Product(12, "Bocanc3", 300));
		return products;
	}

	public static Set<Product> getBoots() {
		return boots;
	}

	public static Set<Product> getProducts() {
		return products;
	}

}
