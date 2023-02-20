package com.example.Bookstore.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String author;
	private Integer publicationYear;
	private String isbn;
	private Integer price;
	
	public Book() {
		
	}
	
	public Book(String title, String author, Integer publicationYear, String isbn, Integer price) {
		super();
		this.title=title;
		this.author=author;
		this.publicationYear=publicationYear;
		this.isbn=isbn;
		this.price=price;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}


	public String getAuthor() {
		return author;
	}


	public Integer getPublicationYear() {
		return publicationYear;
	}


	public String getIsbn() {
		return isbn;
	}


	public Integer getPrice() {
		return price;
	}



	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPublicationYear(Integer publicationYear) {
		this.publicationYear = publicationYear;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

}
