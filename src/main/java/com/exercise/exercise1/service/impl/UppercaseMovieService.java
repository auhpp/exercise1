package com.exercise.exercise1.service.impl;

import com.exercise.exercise1.dto.request.MovieRequest;
import com.exercise.exercise1.dto.response.MovieResponse;
import com.exercise.exercise1.service.MovieService;
import org.springframework.stereotype.Service;

@Service
public class UppercaseMovieService implements MovieService {

    @Override
    public MovieResponse getMovieResponse(MovieRequest movieRequest) {
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setName(movieRequest.getName().toUpperCase());
        movieResponse.setAuthor(movieRequest.getAuthor().toUpperCase());
        movieResponse.setYearOfRelease(movieRequest.getYearOfRelease());
        return movieResponse;
    }
}
