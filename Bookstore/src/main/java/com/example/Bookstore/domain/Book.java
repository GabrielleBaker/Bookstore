package com.example.Bookstore.domain;

public class Book {
	private String titl;
	private String author;
	private Integer publicationYear;
	private String isbn;
	private Integer price;

	public void setTitl(String titl) {
		this.titl = titl;
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
		return "Book [titl=" + titl + ", author=" + author + ", publicationYear=" + publicationYear + ", isbn=" + isbn
				+ ", price=" + price + "]";
	}

}
