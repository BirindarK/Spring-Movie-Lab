package com.example.labthespringcinema.controllers;

import com.example.labthespringcinema.models.Movie;
import com.example.labthespringcinema.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/movies")
public class MovieController {

    @Autowired
    MovieService movieService;

   @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies(){
       List<Movie> result = movieService.getAllMovies();
       return new ResponseEntity<>(result, HttpStatus.OK);
   }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Movie>> getMovieById(@PathVariable long id) {
        Optional<Movie> movie = movieService.getMovieById(id);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Movie> saveMovie(@RequestBody Movie movieSaved){
       movieService.saveMovie(movieSaved);
       return new ResponseEntity<>(movieSaved, HttpStatus.CREATED);

    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Movie> deleteMovie(@PathVariable long id){
        Optional<Movie> deletedMovie = movieService.getMovieById(id);
        Movie movie = deletedMovie.get();
        movieService.deleteMovie(movie);
        return new ResponseEntity<>(movie, HttpStatus.OK);
    }

    @PatchMapping(value = "/{id}")
    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
       movieService.updateMovie(movie);
       return new ResponseEntity<>(movie, HttpStatus.OK);




    }


}
