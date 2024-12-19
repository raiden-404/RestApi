package com.api.bookmanagment.bookEntitiesAndMethods;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookServiceProvider {
    @Autowired
    private BookRepository bookRepository;

    // Method to return all book in DB
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Method to return book by ID
    public Book getBookById(int id) {
        Book book = bookRepository.findById(id).orElse(null);
        if(book == null ){
            Book bookNotFound = new Book(-1,"-1","-1");
            return bookNotFound;
        }
        return book;
    }

    // Method to add Book
    public String setBook(DTO dto) {
        Book book = new Book();
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        try {
            Book addedBook = bookRepository.save(book);
            if (addedBook.getName().equals(book.getName()) && addedBook.getAuthor().equals(book.getAuthor())) {
                return "Book Added Successfully!!";
            } else {
                return "Error occured to Add";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error";
    }

    // Delete Book by its ID
    public String deleteBookById(int id) {
        try {
            String bookName = bookRepository.findById(id).orElse(null).getName();
            bookRepository.deleteById(id);
            return bookName;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Error";
    }

    // Update Book by its ID
    public String updateBookById(DTO bookDto, int id) {
        Book book = bookRepository.findById(id).orElse(null);
        book.setName(bookDto.getName());
        book.setAuthor(bookDto.getAuthor());
        return bookRepository.save(book).getName();
    }

}
