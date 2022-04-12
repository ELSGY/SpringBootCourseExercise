package com.elysian.springbootexercise.controller;

import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.service.ProductService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping("/getAllProducts")
	public Iterable<Product> getAllProducts(){
		return productService.getAllProducts();
	}
}
