package com.example.Bookstore1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.Bookstore1.domain.Book;
import com.example.Bookstore1.domain.BookRepository;
import com.example.Bookstore1.domain.Category;
import com.example.Bookstore1.domain.CategoryRepository;
import com.example.Bookstore1.domain.User;
import com.example.Bookstore1.domain.UserRepository;



@SpringBootApplication
public class Bookstore1Application {
	@Autowired
	private BookRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(Bookstore1Application.class, args);
	}
	
	
	@Bean
	public CommandLineRunner demo(BookRepository repository, CategoryRepository catRepository, UserRepository uRepository) {
	return (args) -> {
		
		catRepository.save(new Category("None"));
		catRepository.save(new Category("Fantasy"));
		catRepository.save(new Category("Thriller"));
		catRepository.save(new Category("Horror"));
		catRepository.save(new Category("Cookbooks"));
		
		
		Book book = new Book(0 ,"Harri potteri", "J.K", 2017, "128412-1", (double) 123, catRepository.findByName("Fantasy").get(0));
		repository.save(book);
		Book book2 = new Book(0 ," potteri", "J.K", 2017, "128j0412-1", (double) 1293, catRepository.findByName("Horror").get(0));
		repository.save(book2);
		
			
		User user1 = new User( "user", "$2a$06$3jYRJrg0ghaaypjZ/.g4SethoeA51ph3UD4kZi9oPkeMTpjKU5uo6", "USER", "info@bookstore.com");
		User user2 = new User("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN", "admin@bookstore.com");
		uRepository.save(user1);
		uRepository.save(user2);
		

	};
	}

}

