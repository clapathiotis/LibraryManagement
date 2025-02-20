import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-author-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css'],
  standalone: true,
  imports: [CommonModule, FormsModule, HttpClientModule]
})
export class SearchComponent {
  searchType: string = 'author';
  author: string = '';
  title: string = '';
  available: boolean = true;
  books: any[] = [];

  constructor(private http: HttpClient) {}

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