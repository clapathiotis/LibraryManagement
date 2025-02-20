import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-author-search',
  templateUrl: './author-search.component.html',
  styleUrls: ['./author-search.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule]
})
export class AuthorSearchComponent {
  author: string = '';
  books: any[] = [];

  constructor(private http: HttpClient) {}

  searchByAuthor() {
    this.http.get<any[]>(`http://localhost:8080/api/books/search/author?author=${this.author}`)
      .subscribe(data => {
        this.books = data;
      });
  }
}
