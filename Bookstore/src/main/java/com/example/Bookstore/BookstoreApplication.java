package com.example.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.Category;
import com.example.Bookstore.domain.CategoryRepository;


@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository catRepository) {
		return (args) -> {
			catRepository.save(new Category("YA Fantasy"));
			catRepository.save(new Category("SEA Fantasy"));
			catRepository.save(new Category("Adult Fantasy"));
			Book book1 = new Book("Iron Widow", "Xiran Jay Zhao", 2021, "22259-89", 20,
					catRepository.findByName("SEA Fantasy").get(0));
			Book book2 = new Book("The Priory of the Orange Tree", "Samantha Shannon", 2020, "22251-88", 18,
					catRepository.findByName("YA Fantasy").get(0));
			Book book3 = new Book("An Enchantment of Ravens", "Margaret Rogerson", 2017, "25559-77", 12,
					catRepository.findByName("Adult Fantasy").get(0));
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);
			
			log.info("fetch all students");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
