import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

/// The BookManagementComponent is a standalone component
/// It is decorated with the @Component decorator
/// The @Component decorator takes a metadata object that tells Angular
/// how to compile and run the component
@Component({
  selector: 'app-book-management',
  templateUrl: './book-management.component.html',
  styleUrls: ['./book-management.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule]
})

/// The BookManagementComponent class is the component class for the BookManagementComponent
/// The class includes all the logic for the BookManagementComponent
/// The class is exported so that it can be imported in other parts of the application
export class BookManagementComponent {

  /// The books array is an array of objects, each obbject representing a book
  books: any[] = [];
  newBook: any = { title: '', author: '', available: true }; // Available is set to true by default as new books are available
  searchType: string = '';
  author: string = '';
  title: string = '';
  available: boolean = true;

  // The constructor method is called when an instance of the BookManagementComponent class is created
  // The constructor method takes an argument of type HttpClient
  // The HttpClient is used to make HTTP requests to the server
  constructor(private http: HttpClient) {}


  // The addBook method is called when the user clicks the Add Book button
  // The method sends a POST request to the server to add a new book (just like in Spring application see main>java>com>example>library>BookController.java)
  addBook() {
    this.http.post<any>('http://localhost:8080/api/books', this.newBook).subscribe(data => {
      this.books.push(data);
      this.newBook = { title: '', author: '', available: true };
    });
  }

  // The deleteBook method is called when the user clicks the Delete button
  // The method sends a DELETE request to the server to delete a book (just like in Spring application see main>java>com>example>library>BookController.java)
  deleteBook(id: number) {
    this.http.delete(`http://localhost:8080/api/books/${id}`).subscribe(() => {
      this.books = this.books.filter(book => book.id !== id);
    });
  }

  // The listAllBooks method is called when the user clicks the List All Books button
  // The method sends a GET request to the server to get all the books (just like in Spring application see main>java>com>example>library>BookController.java)
  listAllBooks() {
    this.http.get<any[]>('http://localhost:8080/api/books').subscribe(data => {
      this.books = data;
    });
  }

  // The searchBooks method is called when the user clicks the Search button
  // The method sends a GET request to the server to search for books based on the search criteria
  // The search criteria can be author, title, or availability
  // The search criteria is specified by the user in the searchType, author, title, and available fields
  searchBooks() {
    let url = '';
    if (this.searchType === 'author') {
      url = `http://localhost:8080/api/books/search/author?author=${this.author}`;
    } else if (this.searchType === 'title') {
      url = `http://localhost:8080/api/books/search/title?title=${this.title}`;
    } else if (this.searchType === 'available') {
      url = `http://localhost:8080/api/books/search/available?available=${this.available}`;
    }

    // The search results are displayed in the books array
    this.http.get<any[]>(url).subscribe(data => {
      this.books = data;
    });
  }

  // The borrowBook method is called when the user clicks the Borrow button
  // The method sends a PUT request to the server to borrow a book (just like in Spring application see main>java>com>example>library>BookController.java)
  // Sets availability to false
  borrowBook(id: number) {
    this.http.put(`http://localhost:8080/api/books/${id}/borrow`, {}).subscribe(() => {
      this.books = this.books.map(book => {
        if (book.id === id) {
          book.available = false;
        }
        return book;
      });
    });
  }

  // The returnBook method is called when the user clicks the Return button
  // The method sends a PUT request to the server to return a book 
  // Sets availability to true
  returnBook(id: number) {
    this.http.put(`http://localhost:8080/api/books/${id}/return`, {}).subscribe(() => {
      this.books = this.books.map(book => {
        if (book.id === id) {
          book.available = true;
        }
        return book;
      });
    });
  }
}
