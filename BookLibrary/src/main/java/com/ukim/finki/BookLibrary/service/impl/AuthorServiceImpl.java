package com.ukim.finki.BookLibrary.service.impl;

import com.ukim.finki.BookLibrary.models.Author;
import com.ukim.finki.BookLibrary.models.Country;
import com.ukim.finki.BookLibrary.repository.AuthorRepository;
import com.ukim.finki.BookLibrary.repository.CountryRepository;
import com.ukim.finki.BookLibrary.service.AuthorService;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl (AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Author> findAll () {
        return this.authorRepository.findAll ();
    }

    @Override
    public Author findById (Long id) {
        return this.authorRepository.getById (id);
    }

    @Override
    public void deleteById (Long id) {
        this.authorRepository.deleteById (id);
    }

    @Override
    public Author addAuthor (String name, String surname, Long countryId) {
        Country country = this.countryRepository.getById (countryId);
        return this.authorRepository.save (new Author (name,surname,country));
    }
}
