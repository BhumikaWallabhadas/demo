package com.springboot.demo.Service;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.demo.Models.Book;
import com.springboot.demo.Repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	BookRepository bookRepository;
	//get
	public Optional<Book> getBook(String Id) {
		return bookRepository.findById(Id);
		}
	
	//create
	public void createBook(Book book) {
		System.out.print("service1");
		
		bookRepository.save(book);
	}
	//list
	public List<Book> getAllBooks(){
		return  bookRepository.findAll();
	}
	
	//delete
	public void deleteBook(String id) {
		if (bookRepository.findById(id)== null)
		{}
		else
			bookRepository.deleteById(id);
		}
	//update
	public Book updateBook(Book book) {
		bookRepository.save(book);
		return book;}
		
		
		
	}

