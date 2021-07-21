package com.springboot.demo.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.demo.Models.Book;
import com.springboot.demo.Service.BookService;

@RestController
public class BookController {
	@Autowired
	BookService bookService;

	//get
	@GetMapping(value = "/Book/{id}")
	public ResponseEntity<Book> getController(@PathVariable("id") String id) {
		if (bookService.getBook(id)== null) {
			ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
		return ResponseEntity.of(bookService.getBook(id));
		
		
	}
	
	//create
	@PostMapping(value = "/Book")
	public Book createController(@RequestBody Book book) {
		System.out.print("con1");
		 bookService.createBook(book);
		 return book;
		
		}
	
	//Delete
	@DeleteMapping("/Book/{id}")
	public ResponseEntity<Void> deleteController(@PathVariable("id") String id) {
		try {
			bookService.deleteBook(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();			
		}
		catch (Exception e){
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
		}
		
	
	
	//update
	@PutMapping("/Book/{id}")
	public Book updateController(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	//List
	@GetMapping("/Book")
	public ResponseEntity<List<Book>> listController(){
		if (bookService.getAllBooks().size() == 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();}
		return ResponseEntity.of(Optional.of(bookService.getAllBooks()));
		
	
	}
	@GetMapping("/hello")
	public String Hello() {
		return "Hello";
	}
}
