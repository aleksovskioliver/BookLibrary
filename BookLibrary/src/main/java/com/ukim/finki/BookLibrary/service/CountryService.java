package com.ukim.finki.BookLibrary.service;

import com.ukim.finki.BookLibrary.models.Country;

public interface CountryService {

    Country findById(Long id);
    Country addCountry(String name,String continent);
}
