package com.example.Bookstore1.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.Bookstore1.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long>{
	List<Book> findByTitle(String Title);
	
} 
