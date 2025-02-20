import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-book-management',
  templateUrl: './book-management.component.html',
  styleUrls: ['./book-management.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule]
})
export class BookManagementComponent {
  books: any[] = [];
  newBook: any = { title: '', author: '', available: true };
  searchType: string = 'author';
  author: string = '';
  title: string = '';
  available: boolean = true;

  constructor(private http: HttpClient) {}

  addBook() {
    this.http.post<any>('http://localhost:8080/api/books', this.newBook).subscribe(data => {
      this.books.push(data);
      this.newBook = { title: '', author: '', available: true };
    });
  }

  deleteBook(id: number) {
    this.http.delete(`http://localhost:8080/api/books/${id}`).subscribe(() => {
      this.books = this.books.filter(book => book.id !== id);
    });
  }

  listAllBooks() {
    this.http.get<any[]>('http://localhost:8080/api/books').subscribe(data => {
      this.books = data;
    });
  }

  searchBooks() {
    let url = '';
    if (this.searchType === 'author') {
      url = `http://localhost:8080/api/books/search/author?author=${this.author}`;
    } else if (this.searchType === 'title') {
      url = `http://localhost:8080/api/books/search/title?title=${this.title}`;
    } else if (this.searchType === 'available') {
      url = `http://localhost:8080/api/books/search/available?available=${this.available}`;
    }

    this.http.get<any[]>(url).subscribe(data => {
      this.books = data;
    });
  }
}
