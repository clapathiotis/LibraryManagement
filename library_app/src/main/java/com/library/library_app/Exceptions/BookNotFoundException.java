package com.library.library_app.Exceptions;

public class BookNotFoundException extends RuntimeException {

    // Custom exception to be thrown when a book cannot be found
    // Can be because of wrong ID, title, author etc
    public BookNotFoundException(String message) {
        super(message);
    }
}
