package com.example.labthespringcinema.components;

import com.example.labthespringcinema.models.Movie;
import com.example.labthespringcinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

    @Component
    public class DataLoader implements ApplicationRunner {
        @Autowired
        MovieRepository movieRepository;

        Movie movie1 = new Movie("Brother Bear", "PG", 85);
        Movie movie2 = new Movie("The Nun", "R", 96);
        Movie movie3 = new Movie("Avatar", "PG-13", 162);

//        Deleted movie since it is a TV show
        Movie movie4 = new Movie("Invincible", "TV-MA", 45);

//        Updated movie since there are errors

        Movie movie5 = new Movie("Mogwli","R", 500);

        @Override
        public void run(ApplicationArguments args) throws Exception {
            movieRepository.save(movie1);
            movieRepository.save(movie2);
            movieRepository.save(movie3);
            movieRepository.save(movie4);
            movieRepository.save(movie5);
        }
    }

