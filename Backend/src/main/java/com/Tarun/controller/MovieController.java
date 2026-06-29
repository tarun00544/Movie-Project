package com.Tarun.controller;

import com.Tarun.model.Movie;
import com.Tarun.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;
import java.util.Arrays;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
@CrossOrigin(origins = "*")
 
 
public class MovieController {
    @Autowired
     
    private MovieService movieService;

    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

   @PostMapping
public Movie addMovie(@RequestBody Movie movie) {
    return movieService.addMovie(movie);
}
     

@GetMapping("/{id}")
public Movie getMovieById(@PathVariable String id) {
    return movieService.getMovieById(id);
}

@PutMapping("/{id}")
public Movie updateMovie(@PathVariable String id,
                         @RequestBody Movie movie) {
    return movieService.updateMovie(id, movie);
}

@DeleteMapping("/{id}")
public String deleteMovie(@PathVariable String id) {
    movieService.deleteMovie(id);
    return "Movie deleted successfully!";
}
 
}