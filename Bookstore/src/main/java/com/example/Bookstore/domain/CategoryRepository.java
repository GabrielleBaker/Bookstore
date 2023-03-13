package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	Category findById(long id);
	//List<Category> findByName(String name);
	List<Category> findByName(@Param("category") String category);
}
