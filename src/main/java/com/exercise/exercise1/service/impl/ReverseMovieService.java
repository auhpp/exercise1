package com.exercise.exercise1.service.impl;

import com.exercise.exercise1.dto.request.MovieRequest;
import com.exercise.exercise1.dto.response.MovieResponse;
import com.exercise.exercise1.service.MovieService;
import org.springframework.stereotype.Service;

@Service
public class ReverseMovieService implements MovieService {

    @Override
    public MovieResponse getMovieResponse(MovieRequest movieRequest) {
        MovieResponse movieResponse = new MovieResponse();
        String reverseNameMovie = new StringBuilder(movieRequest.getName()).reverse().toString();
        movieResponse.setName(reverseNameMovie);
        String reverseAuthorMovie = new StringBuilder(movieRequest.getAuthor()).reverse().toString();
        movieResponse.setAuthor(reverseAuthorMovie);
        movieResponse.setYearOfRelease(movieRequest.getYearOfRelease());
        return movieResponse;
    }
}
