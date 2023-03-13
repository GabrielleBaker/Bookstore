package com.example.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.AppUserRepository;
import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;

@SpringBootTest
//must tell test to not replace datasource 
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class BookRepositoryTests {
	@Autowired
	private BookRepository repository;
	private CategoryRepository catRepository;
	
	
	//search test
	@Test
	public void findByAuthor() {
		List<Book> books = repository.findByAuthor("Xiran Jay Zhao");
		assertThat(books).hasSize(1);
		assertThat(books.get(0).getTitle()).isEqualTo("Iron Widow");
	}
	
//having error with this one test
//create test
	@Test
	public void createNewBook() {
		Book book = new Book("Daughter of the Moon Goddess", "Sue Lynn Tan", 2022, "7775-88", 31, catRepository.findByName("YA Fantasy").get(0));
		repository.save(book);
		assertThat(book.getId()).isNotNull();
	}
//delete test
	@Test
	public void deleteBook() {
		List<Book> books = repository.findByTitle("Iron Widow");
		Book book = books.get(0);
		repository.delete(book);
		List<Book> newBooks = repository.findByTitle("Iron Widow");
		assertThat(newBooks).hasSize(0);
	}

}