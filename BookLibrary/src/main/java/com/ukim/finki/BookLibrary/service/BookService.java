package com.ukim.finki.BookLibrary.service;

import com.ukim.finki.BookLibrary.models.Book;
import com.ukim.finki.BookLibrary.models.Category;

import java.util.*;

public interface BookService {

    List<Book> listAll();
    Optional<Book> findBookById(Long id);
    void deleteBook(Long id);
    Book editBook(Long id,String name,Category category,Long author,Integer availableCopies);
    Book markAsTaken(Long id);
    Optional<Book> addBook(String name,String category,Long author,Integer availableCopies);
}
