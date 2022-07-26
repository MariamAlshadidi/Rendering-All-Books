package com.codinDojo.controllers;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codinDojo.models.Book;
import com.codinDojo.services.BookService;


@Controller
@RequestMapping("/books")

public class BookController {
	private final BookService bookService;
	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("")
	public String getAllBooks(Model model) {
		List<Book> books = bookService.getAllBooks();
		model.addAttribute("books", books);
		return "Books/viewAllBooks.jsp";
	}
	
	@RequestMapping("/{bookId}")
	public String viewBook(@PathVariable("bookId") Long bookId, Model model) throws Exception {
		Optional<Book> bookOptional = bookService.getBookById(bookId);
		if(!bookOptional.isPresent()) {
			throw new Exception("Book not found with id:"+ bookId);
		}
		
		Book book = bookOptional.get();
		model.addAttribute("book", book);
		return "Books/viewBook.jsp";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.GET)
	public String createBookView() {
		return "Books/createBook.jsp";
	}
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	public String storeBook(
			@RequestParam(value="title") String title,
			@RequestParam(value="languages") String languages,
			@RequestParam(value="pages") Integer pages,
			@RequestParam(value="description") String description,
			RedirectAttributes redirectAttributes
			) {
		
		Book book = new Book(title, description, languages, pages);
		bookService.createBook(book);
		redirectAttributes.addFlashAttribute("success", "Your book has been created");
		return "redirect:/books/create";
	}
}