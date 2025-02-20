package com.library.library_app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.library_app.Entity.Book;
import com.library.library_app.Service.BookService;

/// Controller for the Book entity
/// Contains methods to add, remove, search for, and update books in the database
/// Utilizing the BookService class and RESTful API

@RestController
@RequestMapping("/api/books")
public class BookController {

    // Injecting the BookService dependency
    @Autowired
    private BookService bookService;

    // Adds a book to the database with POST request
    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    // Removes a book from the database with DELETE request
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.removeBook(id);
        return ResponseEntity.noContent().build();
    }

    // Searches for books by title with GET request
    @GetMapping("/search/title")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        List<Book> books = bookService.findByTitleContaining(title);
        return ResponseEntity.ok(books);
    }

    // Searches for books by author with GET request
    @GetMapping("/search/author")
    public ResponseEntity<List<Book>> searchByAuthor(@RequestParam String author) {
        List<Book> books = bookService.findByAuthorContaining(author);
        return ResponseEntity.ok(books);
    }

    // Searches for books by availability status with GET request
    @GetMapping("/search/available")
    public ResponseEntity<List<Book>> searchByAvailable(@RequestParam boolean available) {
        List<Book> books = bookService.findByAvailable(available);
        return ResponseEntity.ok(books);
    }

    // Returns a list of all books in the database with GET request
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    // Marks a book as borrowed with PUT request
    // Updates the availability status of the book
    @PutMapping("/{id}/borrow")
    public ResponseEntity<Book> markAsBorrowed(@PathVariable Long id) {
        Book book = bookService.markAsBorrowed(id);
        return ResponseEntity.ok(book);
    }

    // Marks a book as returned with PUT request
    // Updates the availability status of the book
    @PutMapping("/{id}/return")
    public ResponseEntity<Book> markAsReturned(@PathVariable Long id) {
        Book book = bookService.markAsReturned(id);
        return ResponseEntity.ok(book);
    }
}
