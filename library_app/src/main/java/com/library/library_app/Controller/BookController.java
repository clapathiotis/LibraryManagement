package com.library.library_app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.library.library_app.Entity.Book;
import com.library.library_app.Service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.removeBook(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/title")
    public ResponseEntity<List<Book>> searchByTitle(@RequestParam String title) {
        List<Book> books = bookService.findByTitleContaining(title);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/author")
    public ResponseEntity<List<Book>> searchByAuthor(@RequestParam String author) {
        List<Book> books = bookService.findByAuthorContaining(author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchByTitleAndAuthor(@RequestParam String title, @RequestParam String author) {
        List<Book> books = bookService.findByTitleAndAuthorContaining(title, author);
        return ResponseEntity.ok(books);
    }

    @GetMapping("/search/available")
    public ResponseEntity<List<Book>> searchByAvailable(@RequestParam boolean available) {
        List<Book> books = bookService.findByAvailable(available);
        return ResponseEntity.ok(books);
    }

    @PutMapping("/{id}/borrow")
    public ResponseEntity<Book> markAsBorrowed(@PathVariable Long id) {
        Book book = bookService.markAsBorrowed(id);
        return ResponseEntity.ok(book);
    }

    @PutMapping("/{id}/return")
    public ResponseEntity<Book> markAsReturned(@PathVariable Long id) {
        Book book = bookService.markAsReturned(id);
        return ResponseEntity.ok(book);
    }
}
