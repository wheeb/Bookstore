package com.example.Bookstore1.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Bookstore1.domain.Book;
import com.example.Bookstore1.domain.BookRepository;
import com.example.Bookstore1.domain.CategoryRepository;





@Controller
public class BookController {
	@Autowired
	private BookRepository repository;
	
	@Autowired
	private CategoryRepository catRepository;
	
	@RequestMapping(value="/booklist")
	public String index(Model model) {
        model.addAttribute("books", repository.findAll());

		return "booklist";
		
	}
	
    @RequestMapping(value = "/add")
    public String addBook(Model model){
    	model.addAttribute("book", new Book());
    	model.addAttribute("categories", catRepository.findAll());
        return "addbook";
    }  

    
    @RequestMapping(value = "/edit/{id}")
    public String addStudent(@PathVariable("id") Long Id, Model model){
    model.addAttribute("book", repository.findById(Id));
	model.addAttribute("categories", catRepository.findAll());
    return "editbook";
    }
    
	// Show all students
    @RequestMapping(value="/login")
    public String login() {	
        return "login";
    }	
    //rest, search by id 
    @RequestMapping(value="/books/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Book> findBookRest(@PathVariable("id") Long id) {	
    	return repository.findById(id);
    }    
    
    //rest post receive 
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    }    
    //rest all books
    @RequestMapping(value="/allbooks", method = RequestMethod.GET)
    public @ResponseBody List<Book> BookListRest() {	
        return (List<Book>) repository.findAll();
    }    
    
    
    
    
    
    // Delete student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long Id, Model model) {
    	repository.deleteById(Id);
        return "redirect:../booklist";
    }
    
}
