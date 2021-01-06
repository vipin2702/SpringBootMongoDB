package com.example.demo.mongodb;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

@Service
public class MongoService {

	@Autowired
	MongoRepo repo;

	@Autowired
	MongoTemplate template;

	public String push(Book book) {
		repo.save(book);
		return book + "pushed";
	}

	public List<Book> getBooks() {
		return repo.findAll();
	}

	public Book getBook(int id) {
		return repo.findById(id).orElse(null);
	}

	public List<Book> getBooksByAuthor(String author) {
		return repo.findAllByAuthor(author);
	}

	public String deleteBookById(int id) {
		repo.deleteById(id);
		return "deleted book of id: " + id;
	}

	public List<Book> getBooksByNameAndAuthor(Request request) {
		return repo.findByNameAndAuthor(request.getName(), request.getAuthor());
	}

	public List<Book> getBooksByNamesAndAuthors(List<Request> request) {

		// return method1(request);
		// return method2(request);
		return method3(request);

	}

	private List<Book> method3(List<Request> request) {

		Query query = new Query();
		query.addCriteria(Criteria.where("author").in(request.get(0).getAuthor()));
		return template.find(query, Book.class);
		
	}

	private List<Book> method1(List<Request> request) {
		List<Book> books = new ArrayList<>();
		for (Request r : request) {
			books.addAll(repo.findByNameAndAuthor(r.getName(), r.getAuthor()));
		}
		return books;
	}

	private List<Book> method2(List<Request> request) {

		List<String> names = new ArrayList<>();
		List<String> authors = new ArrayList<>();
		for (Request r : request) {
			names.add(r.getName());
			authors.add(r.getAuthor());
		}
		return repo.findByNameInAndAuthorIn(names, authors);
	}
}
