package com.elysian.springbootexercise.repository;

import com.elysian.springbootexercise.model.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.Set;

@Repository
public interface SectionRepository extends CrudRepository<Section, Integer> {

	Optional<Set<Section>> findAllByStoreId(final int storeId);
}