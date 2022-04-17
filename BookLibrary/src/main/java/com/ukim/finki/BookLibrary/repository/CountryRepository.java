package com.ukim.finki.BookLibrary.repository;

import com.ukim.finki.BookLibrary.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryRepository extends JpaRepository<Country,Long> {
}
