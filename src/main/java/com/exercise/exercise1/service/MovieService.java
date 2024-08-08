package com.exercise.exercise1.service;

import com.exercise.exercise1.dto.request.MovieRequest;
import com.exercise.exercise1.dto.response.MovieResponse;

import java.util.Set;


public interface MovieService {
    MovieResponse create(MovieRequest movieRequest);
    MovieResponse getMovieById(Long id);
    Set<MovieResponse> getAllMovies();
    void deleteMovieById(Long id);
    MovieResponse update(Long id, MovieRequest movieRequest);
}
