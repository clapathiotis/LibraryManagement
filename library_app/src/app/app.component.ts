import { Component } from '@angular/core';
import { AuthorSearchComponent } from './search_component/search.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  standalone: true,
  imports: [AuthorSearchComponent]
})
export class AppComponent {
  title = 'Library Management System';
}
