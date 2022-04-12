package com.elysian.springbootexercise.controller;

import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.security.Roles;
import com.elysian.springbootexercise.service.ProductService;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

	private final ProductService productService;

	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@Secured(Roles.USER_ROLE)
	@GetMapping("/getAllProducts")
	public String getAllProducts() {
		return productService.getAllProducts().toString();
	}

	@DeleteMapping("/{product}")
	public String deleteProduct(@PathVariable Product product) {
		if (productService.deleteProduct(product))
			return "Product deleted!";
		return "Product couldn't be deleted!";
	}

	@PostMapping
	public String addProduct(@RequestBody Product product) {
		if (productService.addProduct(product))
			return "Product added!";
		return "Product couldn't be added";
	}

	@GetMapping("/{id}")
	public String getAllProducts(@PathVariable int id) {
		return productService.getProductById(id).toString();
	}

}
