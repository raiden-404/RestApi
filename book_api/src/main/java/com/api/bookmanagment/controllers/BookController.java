package com.api.bookmanagment.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.api.bookmanagment.bookEntitiesAndMethods.Book;
import com.api.bookmanagment.bookEntitiesAndMethods.BookServiceProvider;
import com.api.bookmanagment.bookEntitiesAndMethods.DTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


// @Controller
@RestController
public class BookController {
    @Autowired
    private BookServiceProvider bookServiceProvider;
    // @RequestMapping(value = "/book", method=RequestMethod.GET)
    //Sending all books to the server
    @GetMapping("/book")
    public List<Book> getAllBooks() {
        return bookServiceProvider.getAllBooks();
    }
    //Sending single book to the server by his ID
    @GetMapping("/book/{id}")
    public Book getBookById(@PathVariable("id") int id){
        return bookServiceProvider.getBookById(id);
    }
    
    //Fetching Book from server and Adding to the Database
    @PostMapping("/book")
    public String setBook(@RequestBody DTO dto) {
        return bookServiceProvider.setBook(dto);
    }
}
