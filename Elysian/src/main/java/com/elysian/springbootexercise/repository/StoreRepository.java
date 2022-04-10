package com.elysian.springbootexercise.repository;

import com.elysian.springbootexercise.model.Store;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreRepository extends CrudRepository<Store, Integer> {

}