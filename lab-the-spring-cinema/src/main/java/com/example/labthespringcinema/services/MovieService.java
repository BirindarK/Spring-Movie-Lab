package com.example.labthespringcinema.services;

import com.example.labthespringcinema.models.Movie;
import com.example.labthespringcinema.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

@Autowired
    MovieRepository movieRepository;

public MovieService(){

}
public List<Movie> getAllMovies(){
    List<Movie> allMovies = movieRepository.findAll();
    return allMovies;
}

public Optional<Movie> getMovieById(long id){
    return movieRepository.findById(id);
}

public void saveMovie(Movie movie){
    movieRepository.save(movie);
}

public void deleteMovie(Movie movie){
    movieRepository.delete(movie);
}

public void updateMovie(Movie movie, long id){
    movie.setTitle(movie.getTitle());
    movie.setRating(movie.getRating());
    movie.setDuration(movie.getDuration());
    movie.setId(id);
    movieRepository.save(movie);
}

//    public List<Movie> filterMoviesByDuration(int maxDuration){
//        List<Movie> allMovies = movieRepository.findAll();
//        List<Movie> filteredMovies = new ArrayList<>();
//
//        for (Movie movie : allMovies) {
//            if (movie.getDuration() <= maxDuration){
//                filteredMovies.add(movie);
//            }
//        }
//
//        return filteredMovies;
//    }


}
