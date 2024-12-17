package com.api.bookmanagment.bookEntitiesAndMethods;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book,Integer>{
    //automatically gave all books
}
