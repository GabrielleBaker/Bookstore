package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;
@Controller
public class AddController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/addbook",method=RequestMethod.GET)
	public String addBooks(Model model) {
		model.addAttribute("book",new Book());
		return "addbook";
	}
	
	@RequestMapping(value="/savebook", method=RequestMethod.POST)
	public String saveBook(Book book) {
		repository.save(book);
		return "redirect:booklist";

	}
}

