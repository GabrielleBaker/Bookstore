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

import com.example.Bookstore.domain.*;

@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository catRepository,
			AppUserRepository urepository) {
		return (args) -> {
			// some categories
			catRepository.save(new Category("YA Fantasy"));
			catRepository.save(new Category("SEA Fantasy"));
			catRepository.save(new Category("Adult Fantasy"));
			// some books
			Book book1 = new Book("Iron Widow", "Xiran Jay Zhao", 2021, "22259-89", 20,
					catRepository.findByName("SEA Fantasy").get(0));
			Book book2 = new Book("The Priory of the Orange Tree", "Samantha Shannon", 2020, "22251-88", 18,
					catRepository.findByName("YA Fantasy").get(0));
			Book book3 = new Book("An Enchantment of Ravens", "Margaret Rogerson", 2017, "25559-77", 12,
					catRepository.findByName("Adult Fantasy").get(0));
			repository.save(book1);
			repository.save(book2);
			repository.save(book3);

			// Create users: admin/admin user/user
			AppUser user1 = new AppUser("user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6",
					"user@gmail.com", "USER");
			AppUser user2 = new AppUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C",
					"admin@gmail.com", "ADMIN");
			urepository.save(user1);
			urepository.save(user2);

			log.info("fetch all books");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};
	}
}
