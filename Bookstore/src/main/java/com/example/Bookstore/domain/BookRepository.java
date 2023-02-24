package com.example.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long> {
	Book findById(long id);

	List<Book> findByAuthor(@Param("author") String author);
	List<Book> findByTitle(@Param("title") String title);
}
