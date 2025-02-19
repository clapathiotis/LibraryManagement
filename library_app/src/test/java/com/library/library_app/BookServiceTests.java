package com.library.library_app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.library.library_app.Entity.Book;
import com.library.library_app.Repository.BookRepository;
import com.library.library_app.Service.BookService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class BookServiceTests {
    @Mock
    private BookRepository bookRepository;

    @InjectMocks
    private BookService bookService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testAddBook() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.addBook(book);

        assertEquals("Test Book", result.getTitle());
        assertEquals("Test Author", result.getAuthor());
        assertEquals(true, result.isAvailable());
    }

    @Test
    void testRemoveBook() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookRepository.existsById(1L)).thenReturn(true);

        bookService.removeBook(1L);

        verify(bookRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindByTitleContaining() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookRepository.findByTitleContaining("Test")).thenReturn(java.util.List.of(book));

        assertEquals(java.util.List.of(book), bookService.findByTitleContaining("Test"));
    }

    @Test
    void testFindByAuthorContaining() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookRepository.findByAuthorContaining("Author")).thenReturn(java.util.List.of(book));

        assertEquals(java.util.List.of(book), bookService.findByAuthorContaining("Author"));
    }

    @Test
    void testFindByTitleAndAuthorContaining() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookRepository.findByTitleAndAuthorContaining("Test", "Author")).thenReturn(java.util.List.of(book));

        assertEquals(java.util.List.of(book), bookService.findByTitleAndAuthorContaining("Test", "Author"));
    }

    @Test
    void testFindByAvailable() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookRepository.findByAvailable(true)).thenReturn(java.util.List.of(book));

        assertEquals(java.util.List.of(book), bookService.findByAvailable(true));
    }

    @Test
    void testMarkAsBorrowed() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.markAsBorrowed(1L);

        assertEquals(false, result.isAvailable());
    }

    @Test
    void testMarkAsReturned() {
        Book book = new Book();
        book.setId(1L);
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(false);

        when(bookRepository.findById(1L)).thenReturn(java.util.Optional.of(book));
        when(bookRepository.save(book)).thenReturn(book);

        Book result = bookService.markAsReturned(1L);

        assertEquals(true, result.isAvailable());
    }

    @Test
    void testGetAllBooks() {
        Book book = new Book();
        book.setTitle("Test Book");
        book.setAuthor("Test Author");
        book.setAvailable(true);

        when(bookRepository.findAll()).thenReturn(java.util.List.of(book));

        assertEquals(java.util.List.of(book), bookService.getAllBooks());
    }
}
