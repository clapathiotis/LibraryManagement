package com.library.library_app.Repository;

import java.util.List;
import com.library.library_app.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/// Repository for the Book entity
/// Contains methods to search for books by title, author, or availability status
/// @see Book
public interface BookRepository extends JpaRepository<Book, Long> {

    /// Returns a list of books with titles or authors containing the given string or availability status
    /// @param The string or boolean to search books
    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByAvailable(boolean available);
}

