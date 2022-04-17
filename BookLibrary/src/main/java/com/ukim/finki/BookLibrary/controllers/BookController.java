package com.ukim.finki.BookLibrary.controllers;

import com.ukim.finki.BookLibrary.models.Book;
import com.ukim.finki.BookLibrary.models.Category;
import com.ukim.finki.BookLibrary.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping
public class BookController {

    private final BookService bookService;

    public BookController (BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping({"/","/books"})
    public List<Book> listAll(){
        return this.bookService.listAll ();
    }

    @PostMapping("/books/add")
    public ResponseEntity<Book> save(@RequestParam String name,
                                     @RequestParam String category,
                                     @RequestParam Long author,
                                     @RequestParam Integer availableCopies) {
        return this.bookService.addBook (name, category,author,availableCopies)
                .map (book -> ResponseEntity.ok ().body (book))
                .orElseGet (() -> ResponseEntity.badRequest ().build ());
    }
}
