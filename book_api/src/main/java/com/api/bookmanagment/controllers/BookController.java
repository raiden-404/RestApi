package com.api.bookmanagment.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.api.bookmanagment.bookEntitiesAndMethods.Book;
import com.api.bookmanagment.bookEntitiesAndMethods.BookServiceProvider;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// @Controller
@RestController
public class BookController {
    @Autowired
    private BookServiceProvider bookServiceProvider;
    // @RequestMapping(value = "/book", method=RequestMethod.GET)
    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookServiceProvider.getAllBooks();
    }
    
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id){
        return bookServiceProvider.getBookById(id);
    }
}
