package com.api.bookmanagment.bookEntitiesAndMethods;
//Data Transfer Object Used for getting and sending Book info
public class DTO {
    private String name;
    private String author;
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
    
}
