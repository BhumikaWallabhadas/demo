package ControllerTest;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Optional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import com.springboot.demo.Controller.BookController;
import com.springboot.demo.Service.BookService;
import com.springboot.demo.Models.Book;

@SpringBootTest
@AutoConfigureMockMvc
public class BookControllerTest {
	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private BookController bookController;
	
	@MockBean
	private BookService bookService;
	@MockBean
	private Book b;
	
	@BeforeEach
	void setUp() {
		Book book = new Book();
		book.setAuthor("mock_author");
		book.setBookId("1");
		book.setBookName("mock_bookname");
	}
	
	@Test
	public void updateControllerTest() throws Exception {
		Book book = new Book();
		book.setAuthor("mock_author");
		book.setBookId("1");
		book.setBookName("mock_bookname");
		given(bookService.updateBook(Mockito.any(Book.class))).willReturn(book);
		//given(bookService.updateBook(Mockito.any(Book.class)).willReturn(book);
		this.mockMvc.perform(put("/Book")).andExpect(status().isOk());
	
		// given(bookService.updateBook(Mockito.any(Book.class))).willReturn(book);
	 }
	@Test
	public void getControllerTest() throws Exception {
		Book book = new Book();
		book.setAuthor("mock_author");
		book.setBookId("1");
		book.setBookName("mock_bookname");
		Optional<Book> b = Optional.of(book);
		//given(bookService.getBook(Mockito.anyString())).willReturn(book);
		//given(bookService.getBook(book.getBookId())).willReturn(book);
		given(bookService.getBook(Mockito.anyString())).willReturn(b);
		this.mockMvc.perform(get("/Book/{id}",book.getBookId())).andExpect(status().isOk());
	
		// given(bookService.updateBook(Mockito.any(Book.class))).willReturn(book);
	 }
	

}
