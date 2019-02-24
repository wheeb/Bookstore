package com.example.Bookstore1.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String save(Book book){
        repository.save(book);
        return "redirect:booklist";
    } 
    
    @RequestMapping(value = "/edit/{id}")
    public String addStudent(@PathVariable("id") Long Id, Model model){
    model.addAttribute("book", repository.findById(Id));
	model.addAttribute("categories", catRepository.findAll());

    return "editbook";
    }
    
    
    
    // Delete student
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String deleteBook(@PathVariable("id") Long Id, Model model) {
    	repository.deleteById(Id);
        return "redirect:../booklist";
    }
    
}
