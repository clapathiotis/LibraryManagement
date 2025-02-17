package com.library.library_app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.library.library_app")
@EnableJpaRepositories(basePackages = "com.library.library_app.Repository.BookRepository")
public class LibraryAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(LibraryAppApplication.class, args);
	}

}
