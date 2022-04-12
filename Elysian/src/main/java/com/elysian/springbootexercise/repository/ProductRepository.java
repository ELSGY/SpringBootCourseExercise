package com.elysian.springbootexercise.repository;

import com.elysian.springbootexercise.database.DataInitialization;
import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.model.Section;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

	private final List<Product> products = new ArrayList<>(DataInitialization.getProducts());
	private final List<Section> sections = new ArrayList<>(DataInitialization.getSections());

	public List<Product> getAllProducts() {
		return products;
	}

	public Product getProductById(int id) {
		return products.get(id);
	}

	public boolean addProduct(Product product) {
		try {
			products.add(product);
			return true;
		} catch (Exception e) {
			// logging
			return false;
		}
	}

	public boolean deleteProduct(Product product) {
		try {
			products.remove(product);
			sections.forEach(section -> section.getProducts().forEach(prod -> {
				if (prod.equals(product)) {
					section.getProducts().remove(prod);
				}
			}));
			return true;
		} catch (Exception e) {
			// logging
			return false;
		}
	}

	public boolean addSectionToProduct(int sectionId, Product product) {
		try {
			products.get((int) product.getId()).setSection(sections.get(sectionId));
			sections.forEach(section -> section.getProducts().forEach(prod -> {
				if (prod.equals(product)) {
					prod.setSection(sections.get(sectionId));
				}
			}));
			return true;
		} catch (Exception e) {
			// logging
			return false;
		}
	}

}