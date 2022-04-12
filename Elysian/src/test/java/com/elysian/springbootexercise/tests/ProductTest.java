package com.elysian.springbootexercise.tests;

import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.repository.ProductRepository;
import com.elysian.springbootexercise.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class ProductTest {

	@Mock
	private ProductRepository productRepository; // the collaborator (productRepository) is mocked

	// the tested service; also called 'system under test' // SUT
	@InjectMocks
	private ProductService productService;

	@Test
	@DisplayName("Given there are available products, when retrieving the products then products are retrieved correctly")
	void givenThereAreAvailableProducts_whenRetrievingProducts_thenProductsAreRetrievedCorrectly() {
		// arrange, including mocking behavior setup    --> given
		final List<Product> products = Arrays.asList(
				new Product("Manusa1"),
				new Product("Bocanci2")
		);
		when(productRepository.getAllProducts()).thenReturn(products);

		final List<Product> allProducts = productService.getAllProducts();

		assertNotNull(allProducts, "The products are null");
		assertEquals(allProducts.size(), products.size(), "Not all the products were returned");
		assertTrue(allProducts.iterator().hasNext(), "There is just a single product");
		allProducts.forEach(product -> {
			assertThat(product.getId(), not(0));
			assertThat("The name must not be null or empty", StringUtils.hasLength(product.getName()));
		});
	}

	@Test
	@DisplayName("Given there are available products, when retrieving a product by ID then the product is retrieved")
	void givenThereAreAvailableProducts_whenRetrievingAProductById_thenTheProductIsCorrectlyRetrieved() {
		final long productId = 20;

		final Product product = mock(Product.class);
		final String mockedName = "mocked name";
		when(product.getName()).thenReturn(mockedName);
		when(product.getId()).thenReturn(productId);

		when(productRepository.getProductById((int) productId)).thenReturn(product);

		final Product resulted = productService.getProductById((int) productId);

		assertNotNull(resulted);
		assertThat(resulted.getName(), is(mockedName));
		assertThat(resulted.getId(), not(0));
		assertThat(resulted.getId(), is(productId));
	}
}
