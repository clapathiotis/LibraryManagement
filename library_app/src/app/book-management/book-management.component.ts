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
}
