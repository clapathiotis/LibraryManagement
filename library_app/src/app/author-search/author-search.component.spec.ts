import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { AuthorSearchComponent } from './author-search.component';
import { FormsModule } from '@angular/forms';

describe('AuthorSearchComponent', () => {
  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [HttpClientTestingModule, FormsModule],
      declarations: [AuthorSearchComponent]
    }).compileComponents();
  });

  it('should create', () => {
    const fixture = TestBed.createComponent(AuthorSearchComponent);
    const component = fixture.componentInstance;
    expect(component).toBeTruthy();
  });
});