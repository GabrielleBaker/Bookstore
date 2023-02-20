package com.example.Bookstore.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.Bookstore.domain.Book;
import com.example.Bookstore.domain.BookRepository;

@Controller
public class EditController {
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/editbook/{id}",method=RequestMethod.GET)
	public String editbook(@PathVariable("id") Long bookId,Model model) {

		model.addAttribute("book",repository.findById(bookId));
		return "editbook";
	}
	
	@RequestMapping(value="/saveedit", method=RequestMethod.POST)
	public String saveEdit(Book book) {
		repository.save(book);
		return "redirect:booklist";

	}
	
}
