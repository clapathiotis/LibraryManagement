import { Component } from '@angular/core';
import { BookManagementComponent } from './book-management/book-management.component';

/// Referring to the BookManagementComponent in the imports array
/// of the @Component decorator
/// This is to ensure that the BookManagementComponent is loaded
/// when the AppComponent is loaded
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
