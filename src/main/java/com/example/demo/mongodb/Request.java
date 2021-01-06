package com.example.demo.mongodb;

public class Request {
	
	private String name;
	private String author;

	public Request() {
		super();
	}
	
	public Request(String name, String author) {
		super();
		this.name = name;
		this.author = author;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
}
