package com.ukim.finki.BookLibrary.service.impl;

import com.ukim.finki.BookLibrary.models.Author;
import com.ukim.finki.BookLibrary.models.Book;
import com.ukim.finki.BookLibrary.models.Category;
import com.ukim.finki.BookLibrary.repository.AuthorRepository;
import com.ukim.finki.BookLibrary.repository.BookRepository;
import com.ukim.finki.BookLibrary.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl (BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> listAll () {
        return this.bookRepository.findAll ();
    }

    @Override
    public Optional<Book> findBookById (Long id) {
        return this.bookRepository.findById (id);
    }

    @Override
    public void deleteBook (Long id) {
        Optional<Book> book = this.bookRepository.findById (id);
        this.bookRepository.deleteById (id);

    }

    @Override
    public Book editBook (Long id, String name, Category category, Long authorId, Integer availableCopies) {
            Book book = this.bookRepository.getById (id);
            Author author = this.authorRepository.getById (authorId);
            book.setName (name);
            book.setAuthor (author);
            book.setAvailableCopies (availableCopies);
            return this.bookRepository.save (book);
    }

    @Override
    public Book markAsTaken (Long id) {
        Book book = this.bookRepository.getById (id);
        Integer availableCopies = book.getAvailableCopies ();
        book.setAvailableCopies (availableCopies-1);
        return this.bookRepository.save (book);
    }

    @Override
    public Optional<Book> addBook (String name, String category, Long authorId,Integer availableCopies) {
        Author author = this.authorRepository.getById (authorId);
        Category categoryToAdd;
        switch (category){
            case "THRILLER": categoryToAdd = Category.THRILER;
            case "DRAMA": categoryToAdd = Category.DRAMA;
            case "NOVEL": categoryToAdd = Category.NOVEL;
            default: categoryToAdd = Category.BIOGRAPHY;
        }
        return Optional.of (this.bookRepository.save (new Book (name,categoryToAdd,author,availableCopies)));
    }
}
