package com.api.bookmanagment.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.api.bookmanagment.bookEntitiesAndMethods.Book;
import com.api.bookmanagment.bookEntitiesAndMethods.BookServiceProvider;
import com.api.bookmanagment.bookEntitiesAndMethods.DTO;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;



// @Controller
@RestController
public class BookController {
    @Autowired
    private BookServiceProvider bookServiceProvider;
    // @RequestMapping(value = "/book", method=RequestMethod.GET)
    //Sending all books to the server
    @GetMapping("/book")
    public ResponseEntity<List<Book>> getAllBooks() {
        if(bookServiceProvider.getAllBooks().size() <= 0){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.ofNullable(bookServiceProvider.getAllBooks()));
    }

    //Sending single book to the server by his ID
    @GetMapping("/book/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable("id") int id){
        if(bookServiceProvider.getBookById(id) == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.ofNullable(bookServiceProvider.getBookById(id)));
    }
    
    //Fetching Book from server and Adding to the Database
    @PostMapping("/book")
    public ResponseEntity<String> setBook(@RequestBody DTO dto) {
        if(dto.getName() == null || dto.getAuthor() == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        if(bookServiceProvider.setBook(dto).equals("Book Added Successfully!!")){
            return ResponseEntity.ok("Book Added Successfully!!");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    //Deleting Book by ID
    @DeleteMapping("/book/delete/{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable("id") int id){
        String name = bookServiceProvider.getBookById(id).getName();
        if(bookServiceProvider.deleteBookById(id).equals(name)){
            return ResponseEntity.ok("Book: \""+name+"\" is Successfully Deleted!!");
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    //Update Book by ID
    @PutMapping("book/{id}")
    public String updateBookById(@RequestBody DTO bookDto,@PathVariable int id) {
        return "Book: \""+bookServiceProvider.updateBookById(bookDto, id)+"\" is Successfully Updated!!";
    }
}