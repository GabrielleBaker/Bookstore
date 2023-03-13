package com.example.Bookstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

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

	@ManyToOne
	@JsonIgnore
	@JoinColumn(name = "categoryId")
	private Category category;

	public Book() {

	}

	public Book(String title, String author, Integer publicationYear, String isbn, Integer price, Category category) {
		super();
		this.title = title;
		this.author = author;
		this.publicationYear = publicationYear;
		this.isbn = isbn;
		this.price = price;
		this.category=category;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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
	
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		if (this.category != null)
			return "Book [id=" + id + ", title=" + title + ", author=" +author + ", Year=" + publicationYear + ", ISBN="+ isbn + ", price=" + price + ", category =" + this.getCategory() + "]";		
		else
			return "Book [id=" + id + ", title=" + title + ", author=" + author + ", year=" + publicationYear + ", ISBN="+ isbn+ ", price=" + price+"]";
	}

	
	

}
