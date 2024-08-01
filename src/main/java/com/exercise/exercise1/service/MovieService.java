package com.exercise.exercise1.service;

import com.exercise.exercise1.dto.request.MovieRequest;
import com.exercise.exercise1.dto.response.MovieResponse;


public interface MovieService {
    MovieResponse getMovieResponse(MovieRequest movieRequest);
}
