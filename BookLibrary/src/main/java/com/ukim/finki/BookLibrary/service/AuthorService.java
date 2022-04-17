package com.ukim.finki.BookLibrary.service;

import com.ukim.finki.BookLibrary.models.Author;
import com.ukim.finki.BookLibrary.models.Book;
import com.ukim.finki.BookLibrary.models.Country;

import javax.persistence.ManyToOne;
import java.util.*;

public interface AuthorService {

    List<Author> findAll();
    Author findById(Long id);
    void deleteById(Long id);
    Author addAuthor(String name, String surname,Long countryId);
}
