package com.example.labthespringcinema.repositories;

import com.example.labthespringcinema.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
