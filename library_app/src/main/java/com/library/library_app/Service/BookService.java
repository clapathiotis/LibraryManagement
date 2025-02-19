package com.library.library_app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_app.Entity.Book;
import com.library.library_app.Exceptions.BookNotFoundException;
import com.library.library_app.Repository.BookRepository;

@Service
public class BookService {

    @Autowired
    public BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void removeBook(Long id) {
        if (!bookRepository.existsById(id)) {
            throw new BookNotFoundException("Book not found with id: " + id);
        }
        bookRepository.deleteById(id);
    }

    public List<Book> findByTitleContaining(String title) {
        return bookRepository.findByTitleContaining(title);
    }

    public List<Book> findByAuthorContaining(String author) {
        return bookRepository.findByAuthorContaining(author);
    }

    public List<Book> findByTitleAndAuthorContaining(String title, String author) {
        return bookRepository.findByTitleAndAuthorContaining(title, author);
    }

    public List<Book> findByAvailable(boolean available) {
        return bookRepository.findByAvailability(available);
    }

    public Book markAsBorrowed(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        book.setAvailable(false);
        return bookRepository.save(book);
    }

    public Book markAsReturned(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new BookNotFoundException("Book not found with id: " + id));
        book.setAvailable(true);
        return bookRepository.save(book);
    }

}
