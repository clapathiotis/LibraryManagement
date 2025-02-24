import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';

//// The AppModule class is the root module of the Angular application
//// It is decorated with the @NgModule decorator
//// The @NgModule decorator takes a metadata object that tells Angular
//// how to compile and run the application
//// The metadata object has the following properties:
//// declarations: An array of components, directives, and pipes that belong to the module
//// imports: An array of modules that the module depends on
//// providers: An array of services that the module provides
//// bootstrap: The root component that Angular creates and inserts into the index.html file
@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }