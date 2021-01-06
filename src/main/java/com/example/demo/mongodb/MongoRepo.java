package com.example.demo.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends MongoRepository<Book, Integer> {

	public List<Book> findAllByAuthor(String author);
	public List<Book> findByNameAndAuthor(String name, String author);
	public List<Book> findByNameInAndAuthorIn(List<String> names, List<String> authors);
	public List<Book> findByNameAndAuthor(Iterable<Request> request);
	
}
