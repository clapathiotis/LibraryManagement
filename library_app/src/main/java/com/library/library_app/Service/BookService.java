package com.library.library_app.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.library.library_app.Entity.Book;
import com.library.library_app.Repository.BookRepository;

@Service
public class BookService {

    @Autowired
    public BookRepository bookRepository;

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }
}
