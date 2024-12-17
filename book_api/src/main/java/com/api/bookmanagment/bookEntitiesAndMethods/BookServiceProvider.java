package com.api.bookmanagment.bookEntitiesAndMethods;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class BookServiceProvider {
    @Autowired
    private BookRepository bookRepository;

    //Method to return all book in DB
    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    //Method to return book by ID
    public Book getBookById(int id){
        return bookRepository.findById(id).orElse(null);
    }

    //Method to add Book
    public String setBook(DTO dto){
        Book book = new Book();
        book.setName(dto.getName());
        book.setAuthor(dto.getAuthor());
        Book addedBook = bookRepository.save(book);
        if(addedBook.getName().equals(book.getName())  &&  addedBook.getAuthor().equals(book.getAuthor())){
            return "Book Added Successfully!!";
        }else{
            return "Error occured to Add";
        }
    }
}
