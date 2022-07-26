package com.codinDojo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.codinDojo.models.Book;
import com.codinDojo.repositories.BookRepository;
@Service
public class BookService {
    // adding the book repository as a dependency
    private final BookRepository bookRepository;
 
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    

    
    public List<Book> getAllBooks() {
    	return bookRepository.findAll();
    }
    
    // creates a book
    public Book createBook(Book b) {
        return bookRepository.save(b);
    }
    
    public Optional<Book> getBookById(Long bookId) {
    	return bookRepository.findById(bookId);
    }
    

}