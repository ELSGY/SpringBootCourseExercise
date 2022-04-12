package com.elysian.springbootexercise.repository;

import com.elysian.springbootexercise.database.InitProducts;
import com.elysian.springbootexercise.database.InitSections;
import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.model.Section;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

	private final List<Product> products = new ArrayList<>(InitProducts.getProducts());
	private final List<Section> sections = new ArrayList<>(InitSections.getSections());

	@Autowired
	public ProductRepository() {

	}

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

}