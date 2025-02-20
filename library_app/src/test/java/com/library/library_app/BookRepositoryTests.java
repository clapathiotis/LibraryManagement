package com.library.library_app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.library.library_app.Entity.Book;
import com.library.library_app.Repository.BookRepository;

import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class BookRepositoryTests {
    
    @Autowired
    private BookRepository bookRepository;

    @BeforeEach
    void setUp() {
        Book book1 = new Book();
        book1.setTitle("The Great Wall of Chris");
        book1.setAuthor("Christoforos Lapathiotis");
        book1.setAvailable(true);

        Book book2 = new Book();
        book2.setTitle("The Banana Tree");
        book2.setAuthor("Christoforos Banathiotis");
        book2.setAvailable(true);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }


    @Test
    void testFindByTitleContaining() {
        List<Book> books = bookRepository.findByTitleContaining("Wall");
        assertEquals(1, books.size());
        assertEquals("The Great Wall of Chris", books.get(0).getTitle());
    }
    
    @Test
    void testFindByAuthorContaining() {
        List<Book> books = bookRepository.findByAuthorContaining("Banathiotis");
        assertEquals(1, books.size());
        assertEquals("The Banana Tree", books.get(0).getTitle());
    }

    @Test
    void testFindByAvailable() {
        List<Book> books = bookRepository.findByAvailable(true);
        assertEquals(2, books.size());
        assertTrue(books.stream().anyMatch(book -> book.getTitle().equals("The Great Wall of Chris")));
        assertTrue(books.stream().anyMatch(book -> book.getTitle().equals("The Banana Tree")));
    }
}
