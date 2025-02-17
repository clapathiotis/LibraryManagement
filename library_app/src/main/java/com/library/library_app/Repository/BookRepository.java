package com.library.library_app.Repository;

import java.util.List;
import com.library.library_app.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitleContaining(String title);
    List<Book> findByAuthorContaining(String author);
    List<Book> findByAvailable(boolean available);
    List<Book> findByTitleContainingAndAuthorContaining(String title, String author);
}

