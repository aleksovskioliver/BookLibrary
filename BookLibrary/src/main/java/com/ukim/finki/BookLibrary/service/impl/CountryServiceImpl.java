package com.ukim.finki.BookLibrary.service.impl;

import com.ukim.finki.BookLibrary.models.Country;
import com.ukim.finki.BookLibrary.repository.CountryRepository;
import com.ukim.finki.BookLibrary.service.CountryService;

public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl (CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public Country findById (Long id) {
        return this.countryRepository.getById (id);
    }

    @Override
    public Country addCountry (String name, String continent) {
        return this.countryRepository.save (new Country (name,continent));
    }
}
