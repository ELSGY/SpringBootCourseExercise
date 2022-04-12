package com.elysian.springbootexercise.service;

import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	@Autowired
	public ProductService(final ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	public boolean deleteProduct(final Product product) {
		return productRepository.deleteProduct(product);
	}

	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}

	public boolean addProduct(Product product) {
		return productRepository.addProduct(product);
	}

	public Product getProductById(int id) {
		return productRepository.getProductById(id);
	}

}
