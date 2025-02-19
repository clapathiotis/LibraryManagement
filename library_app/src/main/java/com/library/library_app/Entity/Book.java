package com.library.library_app.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

/// Entity for the Book object
/// Contains the unique identifier, title, author, and availability status of the book
@Entity
public class Book {

    /// The unique identifier for the book
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /// The title of the book
    @NotBlank
    @Size(max = 100)
    private String title;

    /// The author of the book
    @NotBlank
    @Size(max = 100)
    private String author;

    /// The availability status of the book (borrowed or not)
    private boolean available;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
