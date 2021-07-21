package com.springboot.demo.Models;

import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Author {
	@Id
	public String AuthorId;
	public String AuthorName;
	
	public String Book;
	
	
	public Author() {
		super();
		
	}


	public String getAuthorId() {
		return AuthorId;
	}


	public void setAuthorId(String authorId) {
		AuthorId = authorId;
	}


	public String getAuthorName() {
		return AuthorName;
	}


	public void setAuthorName(String authorName) {
		AuthorName = authorName;
	}


	public String getBook() {
		return Book;
	}


	public void setBook(String book) {
		Book = book;
	}


	public Author(String authorId, String authorName, String book) {
		super();
		AuthorId = authorId;
		AuthorName = authorName;
		Book = book;
	}
	
}
