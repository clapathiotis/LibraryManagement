import { Component } from '@angular/core';
import { BookManagementComponent } from './book-management/book-management.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [BookManagementComponent]
})
export class AppComponent {
  title = 'Library Management System';
}
