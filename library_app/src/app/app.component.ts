import { Component } from '@angular/core';
import { SearchComponent } from './search_component/search.component';
import { BookManagementComponent } from './book-management/book-management.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [SearchComponent, BookManagementComponent]
})
export class AppComponent {
  title = 'Library Management System';
}
