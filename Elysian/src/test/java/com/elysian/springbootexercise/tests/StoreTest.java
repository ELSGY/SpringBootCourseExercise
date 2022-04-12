package com.elysian.springbootexercise.tests;

import com.elysian.springbootexercise.model.Product;
import com.elysian.springbootexercise.model.Store;
import com.elysian.springbootexercise.repository.ProductRepository;
import com.elysian.springbootexercise.repository.StoreRepository;
import com.elysian.springbootexercise.service.ProductService;
import com.elysian.springbootexercise.service.StoreService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsNot.not;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class StoreTest {

	@Mock
	private StoreRepository storeRepository; // the collaborator (productRepository) is mocked

	// the tested service; also called 'system under test' // SUT
	@InjectMocks
	private StoreService storeService;

	@Test
	@DisplayName("Given there are available stores, when retrieving the stores then stores are retrieved correctly")
	void givenThereAreAvailableStores_whenRetrievingStores_thenStoresAreRetrievedCorrectly() {
		// arrange, including mocking behavior setup    --> given
		final List<Store> stores = Arrays.asList(
				new Store(1, "Mag1", "Arad"),
				new Store(2, "Timisoara", "Timisoara")
		);
		when(storeRepository.getAllStores()).thenReturn(stores);

		final List<Store> allProducts = storeService.getAllStores();

		assertNotNull(allProducts, "The stores are null");
		assertEquals(allProducts.size(), stores.size(), "Not all the stores were returned");
		assertTrue(allProducts.iterator().hasNext(), "There is just a single store");
		allProducts.forEach(product -> {
			assertThat(product.getId(), not(0));
			assertThat("The name must not be null or empty", StringUtils.hasLength(product.getName()));
		});
	}

	@Test
	@DisplayName("Given a section and a store, when assigning the section to store, the section is assigned correctly")
	void givenSectionAndStore_whenAssignSectionToStore_thenSectionIsAssignedCorrectly() {

		int sectionId = 1;
		int storeId = 1;

		when(storeRepository.addSectionToStore(sectionId, storeId)).thenReturn(true);

		final boolean assigned = storeService.addSectionToStore(sectionId, storeId);

		assertTrue(assigned);
	}
}
