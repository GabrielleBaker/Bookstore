package com.example.Bookstore;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;


@SpringBootApplication
public class BookstoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	@Bean
	public CommandLineRunner demo(BookRepository repository) {
		return (args) -> {
			Book book1 = new Book("Iron Widow","Xiran Jay Zhao",2021,"22259-89",20);
			Book book2 = new Book("The Priory of the Orange Tree","Samantha Shannon",2020,"22251-88",18);
			Book book3 = new Book("An Enchantment of Ravens","Margaret Rogerson",2017,"25559-77",12);		
	repository.save(book1);
	repository.save(book2);
	repository.save(book3);
	
		};
}
}
