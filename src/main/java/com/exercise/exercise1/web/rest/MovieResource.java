package com.exercise.exercise1.web.rest;

import com.exercise.exercise1.dto.request.MovieRequest;
import com.exercise.exercise1.dto.response.MovieResponse;
import com.exercise.exercise1.service.MovieService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/")
public class MovieResource {

    private MovieService movieService;

    public MovieResource(@Qualifier("defaultMovieService") MovieService movieService) {
        this.movieService = movieService;
    }

    //    get movie by id
    @GetMapping("/movies/{movieId}")
    public MovieResponse getMovieById(@PathVariable Long movieId) {
        return movieService.getMovieById(movieId);
    }

    //    get all movie
    @GetMapping("/movies")
    public Set<MovieResponse> getAllMovies() {
        return movieService.getAllMovies();
    }

    //    create movie
    @PostMapping("/movies")
    public MovieResponse create(@RequestBody MovieRequest movieRequest) {
        return movieService.create(movieRequest);
    }

    //    update movie
    @PutMapping("/movies/{id}")
    public MovieResponse update(@PathVariable Long id, @RequestBody MovieRequest movieRequest) {
        return movieService.update(id, movieRequest);
    }

    //     delete movie by id
    @DeleteMapping("movies/{id}")
    public void deleteMovieById(@PathVariable Long id) {
        movieService.deleteMovieById(id);
    }

}
