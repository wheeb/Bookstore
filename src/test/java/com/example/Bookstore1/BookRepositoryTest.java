package com.example.Bookstore1;


import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Bookstore1.domain.BookRepository;
import com.example.Bookstore1.domain.Category;
import com.example.Bookstore1.domain.Book;


@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {

    @Autowired
    private BookRepository repository;

    @Test
    public void findBynameShouldReturnBook() {
        List<Book> books = repository.findByTitle("Harri potteri");
        
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("J.K");
    }
    
    @Test
    public void createNewStudent() {
    	Book student = new Book(0 ,"Harri", "Java", 2017, "12841222-1", (double) 123, new Category("Book"));
    	repository.save(student);
    	assertThat(student.getId()).isNotNull();
    }    

}