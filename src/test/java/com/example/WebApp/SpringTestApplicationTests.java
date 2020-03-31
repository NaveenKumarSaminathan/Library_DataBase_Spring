package com.example.WebApp;

import com.example.WebApp.controller.AppController;
import static org.junit.Assert.*;

import com.example.WebApp.dao.BookRepo;
import com.example.WebApp.model.Book;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;

import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class SpringTestApplicationTests {

	@InjectMocks
	AppController appController;

	@Mock
	private BookRepo bookRepo;

	SpringTestApplicationTests() {
	}

	@Before
	public void setUp(){
		//appController = new AppController();
	}

//	@Test
//	public void testForHome() {
//		//AppController appController = new AppController();
//		//System.out.println("Hello test");
//		assertEquals("Welcome to Home page", HomeController.home());
//	}

	@Test
	public void saveBookTestForPass(){
		Book b = new Book(11,"Rice Grain","Nessi Firidolfi","Comedy|Documentary","true");
		when(bookRepo.save(b)).thenReturn(b);
		when(bookRepo.findById(b.getBid())).thenReturn(Optional.empty());
		assertEquals("Book saved", appController.saveBook(b));
	}

	@Test
	public void saveBookTestForFail(){
		Book b = new Book(3,"Rice Grain","Nessi Firidolfi","Comedy|Documentary","true");
		when(bookRepo.save(b)).thenReturn(b);
		when(bookRepo.findById(b.getBid())).thenReturn(Optional.of(b));
		assertEquals("Book already present", appController.saveBook(b));
	}

    @Test
    public void getBookTestForPass(){
		Book b = new Book(2,"Rice Grain","Nessi Firidolfi","Comedy|Documentary","true");
		Optional<Book> ob = java.util.Optional.of(b);
		int bid = 2;
		when(bookRepo.findById(bid)).thenReturn(ob);
		assertEquals(ob, appController.getBook(bid));
	}

	@Test
	public void getBookTestForNull(){
		int bid = 100;
		//String output = "Book is not created";
		Book b = new Book();
		Optional<Book> ob = java.util.Optional.of(b);
		when(bookRepo.findById(bid)).thenReturn(ob);
		assertEquals(ob,appController.getBook(bid));
	}

	@Test
	public void getAllBooksTest(){
		//BookRepo bookRepo = mock(BookRepo.class);

		List<Book> b = Collections.singletonList(new Book(2, "Rice Grain", "Nessi Firidolfi", "Comedy|Documentary", "true"));
		when(bookRepo.findAll()).thenReturn(b);
		assertEquals(b, appController.getAllBooks());
	}

	@Test
	public void updateBookTestForPass(){
		Book b = new Book(3,"Rice Grain","Nessi Firidolfi","Comedy|Documentary","true");
		Optional<Book> ob = Optional.of(b);
		doNothing().when(bookRepo).setFixedAvailabilityFor(b.getBid(),b.getAvailability());
		when(bookRepo.findById(b.getBid())).thenReturn(ob);
		assertEquals("Book Updated", appController.updateBook(b.getBid(), b.getAvailability()));
	}

	@Test
	public void updateBookTestForFail(){

		int bid = 11;
		String availability = "False";
		doNothing().when(bookRepo).setFixedAvailabilityFor(bid, availability);
		when(bookRepo.findById(bid)).thenReturn(Optional.empty());
		assertEquals("Book is not available. Create a new Book", appController.updateBook(bid, availability));
	}


	@Test
	public void deleteBookTestForPass(){
		int bid = 1;
		AppController appController = mock(AppController.class);
		doNothing().when(bookRepo).deleteById(bid);
		assertNull(appController.deleteBook(bid));
		verify(appController).deleteBook(bid);
	}
}
