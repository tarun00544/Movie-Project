package com.Tarun.service;

import com.Tarun.model.Movie;
import com.Tarun.repository.MovieRepository;
 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import java.util.List;

@Service
 
public class MovieService {

    
    
    @Autowired
    private MovieRepository movieRepository;

    // Get all movies
    public List<Movie> getAllMovies() {
        return movieRepository.findAll();
    }

    // Add movie
    public Movie addMovie(Movie movie) {
        return movieRepository.save(movie);
    }


// Get movie by id
public Movie getMovieById(String id) {
    return movieRepository.findById(id).orElse(null);
}

// Update movie
public Movie updateMovie(String id, Movie updatedMovie) {
    Movie movie = movieRepository.findById(id).orElse(null);

    if (movie != null) {
        movie.setTitle(updatedMovie.getTitle());
        movie.setGenre(updatedMovie.getGenre());
        movie.setLanguage(updatedMovie.getLanguage());
        movie.setReleaseYear(updatedMovie.getReleaseYear());
        movie.setDuration(updatedMovie.getDuration());
        movie.setRating(updatedMovie.getRating());
        movie.setDirector(updatedMovie.getDirector());
        movie.setCast(updatedMovie.getCast());
        movie.setDescription(updatedMovie.getDescription());
        movie.setPosterUrl(updatedMovie.getPosterUrl());
        movie.setTrailerUrl(updatedMovie.getTrailerUrl());

        return movieRepository.save(movie);
    }

    return null;
}

 
    

// Delete movie
public void deleteMovie(String id) {
    movieRepository.deleteById(id);
}

 

 
}