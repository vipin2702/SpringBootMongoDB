package com.example.demo.mongodb;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MongoController {

	@Autowired
	MongoService service;
	
	@GetMapping("/")
	public List<Book> getData() {
		return service.getBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable int id) {
		return service.getBook(id);
	}
	
	@GetMapping("/books/{author}")
	public List<Book> getBooksByAuthor(@PathVariable String author) {
		return service.getBooksByAuthor(author);
	}
	
	@PostMapping("/books/")
	public List<Book> getBooksByNameAndAuthor(@RequestBody Request request) {
		return service.getBooksByNameAndAuthor(request);
	}
	
	@PostMapping("/books/v2/")
	public List<Book> getBooksByNamesAndAuthors(@RequestBody List<Request> request) {
		return service.getBooksByNamesAndAuthors(request);
	}
	
	@PostMapping("/add")
	public String push(@RequestBody Book book) {
		return service.push(book);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteBook(@PathVariable int id) {
		return service.deleteBookById(id);
	}
}
