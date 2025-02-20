package com.library.library_app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_app.Entity.Book;
import com.library.library_app.Exceptions.BookNotFoundException;
import com.library.library_app.Repository.BookRepository;

/// Service for the Book entity
/// Contains methods to add, remove, search for, and update books
@Service
public class BookService {

    // Automatically injects the BookRepository dependency
    @Autowired
    public BookRepository bookRepository;

    // Adds a book to the database and makes the book available
    public Book addBook(Book book) {
        book.setAvailable(true);
        return bookRepository.save(book);
    }

    // Returns a list of all books in the database
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Removes a book from the database
    public void removeBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    // Searches for books by title, author, or availability status
    public List<Book> findByTitleContaining(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    // Searches for books by author
    public List<Book> findByAuthorContaining(String author) {
        return bookRepository.findByAuthorContaining(author);
    }

    // Searches for books by availability status
    public List<Book> findByAvailable(boolean available) {
        return bookRepository.findByAvailable(available);
    }

    // Marks a book as borrowed
    public Book markAsBorrowed(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        book.setAvailable(false);
        return bookRepository.save(book);
    }

    // Marks a book as returned
    public Book markAsReturned(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        book.setAvailable(true);
        return bookRepository.save(book);
    }

}
