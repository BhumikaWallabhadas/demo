package com.springboot.demo.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Book")
public class Book {

	@Id
	
	public String BookId;
	public String BookName;
	public String Author;
	
	public Book() {
		super();
		
	}
	public Book(String bookId, String bookName, String author) {
		super();
		this.BookId = bookId;
		this.BookName = bookName;
		this.Author = author;
	}
	public String getBookId() {
		return BookId;
	}
	public void setBookId(String bookId) {
		this.BookId = bookId;
	}
	public String getBookName() {
		return BookName;
	}
	public void setBookName(String bookName) {
		this.BookName = bookName;
	}
	public String getAuthor() {
		return Author;
	}
	public void setAuthor(String author) {
		this.Author = author;
	}
}
