package com.example.Bookstore.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
import com.example.Bookstore.domain.CategoryRepository;

@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	@Autowired
	private CategoryRepository catRepository;

//log in
	//returning booklist
//	@RequestMapping(value = { "/", "/booklist" })
	//public String homeSecure(Model model) {
		//model.addAttribute("books", repository.findAll());
		//return "booklist";
	//}
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/logout")
	public String logout() {
		return "login";
	}

	//ensuring login details
	@RequestMapping(value = "/booklist")
	public String helloSecure(Model model) {
		UserDetails user = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		String username = user.getUsername();
		//System.out.println("USERNAME: " + username);
		model.addAttribute("name", username);
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}

//book list
	//@RequestMapping(value = "/booklist", method = RequestMethod.GET)
	//public String Books(Model model) {
	//	model.addAttribute("books", repository.findAll());
	//	return "booklist";
//	}

//REST get all books
	@RequestMapping(value = "/books", method = RequestMethod.GET)
	public @ResponseBody List<Book> bookListRest() {
		return (List<Book>) repository.findAll();
	}

	// RESTful service to get book by id
	@RequestMapping(value = "/book/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long bookId) {
		return repository.findById(bookId);
	}

//new book
	@RequestMapping(value = "/addbook", method = RequestMethod.GET)
	public String addBooks(Model model) {
		model.addAttribute("book", new Book());
		model.addAttribute("categories", catRepository.findAll());
		return "addbook";
	}

//save book
	@RequestMapping(value = "/savebook", method = RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";

	}

//delete book
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	@PreAuthorize("hasRole('ADMIN')")
	public String deletebook(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
	}

//edit book
	@RequestMapping(value = "/editbook/{id}")
	public String editbook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("book", repository.findById(bookId));
		model.addAttribute("categories", catRepository.findAll());
		return "editbook";
	}

	

}
