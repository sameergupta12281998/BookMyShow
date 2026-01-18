package com.example.bookmyshow.repository;

import com.example.bookmyshow.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {}
