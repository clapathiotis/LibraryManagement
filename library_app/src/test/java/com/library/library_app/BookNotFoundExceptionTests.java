package com.library.library_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

import com.library.library_app.Exceptions.BookNotFoundException;

/// Tests the custom exception to be thrown
public class BookNotFoundExceptionTests {
    
    @Test
    void testBookNotFoundExceptionMessage() {
        String errormsg = "Book not found msg with id: 123";
        BookNotFoundException exception = assertThrows(BookNotFoundException.class, () -> {
            throw new BookNotFoundException(errormsg);
        });

        assertEquals(errormsg, exception.getMessage());
    }
}
