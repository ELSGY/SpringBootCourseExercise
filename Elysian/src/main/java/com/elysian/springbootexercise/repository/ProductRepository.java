package com.elysian.springbootexercise.repository;

import com.elysian.springbootexercise.model.Product;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface ProductRepository extends PagingAndSortingRepository<Product, Integer> {

	Optional<Set<Product>> findAllBySectionId(final int sectionId);
}