package com.api.bookmanagment.bookEntitiesAndMethods;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
    
    @Column(name="book_id",unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="book_name",nullable = false)
    private String name;

    @Column(name = "book_author",nullable = false)
    private String author;


    
    //Constructors
    public Book() {
    }
    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }


    //Getters And Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }


    //toString()
    @Override
    public String toString() {
        return "Book [id=" + id + ", name=" + name + ", author=" + author + "]";
    }

}
