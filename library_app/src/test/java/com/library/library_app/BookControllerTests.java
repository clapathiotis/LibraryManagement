package com.library.library_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import com.library.library_app.Controller.BookController;
import com.library.library_app.Entity.Book;
import com.library.library_app.Service.BookService;

/// Testing the BookController class
/// 
/// The BookController class is a RESTful API controller for the Book entity
/// Contains methods to add, remove, search for, and update books in the database
public class BookControllerTests {
    

    /// Mocking the BookService dependency
    @Mock
    private BookService bookService;

    /// Injecting the BookService dependency into the BookController
    @InjectMocks
    private BookController bookController;

    /// Setting up the Mockito annotations
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    /// Testing the addBook method
    @Test
    void testAddBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookService.addBook(book)).thenReturn(book);

        Book result = bookController.addBook(book);

        assertEquals("Test Book", result.getTitle());
        assertEquals("Test Author", result.getAuthor());
        assertEquals(true, result.isAvailable());
    }

    /// Testing the deleteBook method
    @Test
    void testRemoveBook() {
        Long bookId = 123L;

        doNothing().when(bookService).removeBook(bookId);

        ResponseEntity<Void> result = bookController.deleteBook(bookId);

        verify(bookService, times(1)).removeBook(bookId);
        assertEquals(ResponseEntity.noContent().build(), result);
    }

    /// Testing the searchByTitle method
    @Test
    void testSearchByTitle() {
        String title = "Test Book";

        when(bookService.findByTitleContaining(title)).thenReturn(null);

        ResponseEntity<List<Book>> result = bookController.searchByTitle(title);

        verify(bookService, times(1)).findByTitleContaining(title);
        assertEquals(ResponseEntity.ok(null), result);
    }

    /// Testing the searchByAuthor method
    @Test
    void testSearchByAuthor() {
        String author = "Test Author";

        when(bookService.findByAuthorContaining(author)).thenReturn(null);

        ResponseEntity<List<Book>> result = bookController.searchByAuthor(author);

        verify(bookService, times(1)).findByAuthorContaining(author);
        assertEquals(ResponseEntity.ok(null), result);
    }

    /// Testing the searchByAvailable method
    @Test
    void testSearchByAvailable() {
        boolean available = true;

        when(bookService.findByAvailable(available)).thenReturn(null);

        ResponseEntity<List<Book>> result = bookController.searchByAvailable(available);

        verify(bookService, times(1)).findByAvailable(available);
        assertEquals(ResponseEntity.ok(null), result);
    }

    /// Testing the getAllBooks method
    @Test
    void testGetAllBooks() {
        when(bookService.getAllBooks()).thenReturn(null);

        ResponseEntity<List<Book>> result = bookController.getAllBooks();

        verify(bookService, times(1)).getAllBooks();
        assertEquals(ResponseEntity.ok(null), result);
    }

    /// Testing the markAsBorrowed method
    @Test
    void testMarkAsBorrowed() {
        Long bookId = 123L;
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookService.markAsBorrowed(bookId)).thenReturn(book);

        ResponseEntity<Book> result = bookController.markAsBorrowed(bookId);

        verify(bookService, times(1)).markAsBorrowed(bookId);
        assertEquals(ResponseEntity.ok(book), result);
    }

    /// Testing the markAsReturned method
    @Test
    void testMarkAsReturned() {
        Long bookId = 123L;
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookService.markAsReturned(bookId)).thenReturn(book);

        ResponseEntity<Book> result = bookController.markAsReturned(bookId);

        verify(bookService, times(1)).markAsReturned(bookId);
        assertEquals(ResponseEntity.ok(book), result);
    }    
}
