package com.exercise.exercise1.service.impl;

import com.exercise.exercise1.dto.request.MovieRequest;
import com.exercise.exercise1.dto.response.ActorResponse;
import com.exercise.exercise1.dto.response.MovieResponse;
import com.exercise.exercise1.entity.Actor;
import com.exercise.exercise1.entity.Movie;
import com.exercise.exercise1.exception.BadRequestException;
import com.exercise.exercise1.exception.NotFoundException;
import com.exercise.exercise1.repository.ActorRepository;
import com.exercise.exercise1.repository.MovieRepository;
import com.exercise.exercise1.service.MovieService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class DefaultMovieService implements MovieService {

    @Autowired
    private MovieRepository movieRepository;

    @Autowired
    private ActorRepository actorRepository;

    @Override
    public MovieResponse create(MovieRequest movieRequest) {
        Movie movie = new Movie(movieRequest.getName(), movieRequest.getAuthor(), movieRequest.getYearOfRelease());
        movieRepository.save(movie);
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setName(movie.getName());
        movieResponse.setAuthor(movie.getAuthor());
        movieResponse.setYearOfRelease(movie.getYearOfRelease());
        movieResponse.setId(movie.getId());
        return movieResponse;
    }

    @Override
    public MovieResponse getMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Movie with " + id + " is not found!"
        ));
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setId(movie.getId());
        movieResponse.setName(movie.getName());
        movieResponse.setAuthor(movie.getAuthor());
        movieResponse.setYearOfRelease(movie.getYearOfRelease());
        if (!movie.getActors().isEmpty()) {
            movie.getActors().forEach(
                    item -> {
                        ActorResponse actorResponse = new ActorResponse();
                        actorResponse.setId(item.getId());
                        actorResponse.setName(item.getName());
                        movieResponse.getActors().add(actorResponse);
                    }
            );
        }
        return movieResponse;
    }

    @Override
    public Set<MovieResponse> getAllMovies() {
        Set<MovieResponse> movies = new HashSet<>();
        movieRepository.findAll().forEach(
                movie -> {
                    MovieResponse movieResponse = new MovieResponse();
                    movieResponse.setId(movie.getId());
                    movieResponse.setName(movie.getName());
                    movieResponse.setYearOfRelease(movie.getYearOfRelease());
                    movieResponse.setActorToActorResponse(movie.getActors());
                    movies.add(movieResponse);
                }
        );
        return movies;
    }

    @Override
    public void deleteMovieById(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Movie with " + id + " is not found!")
        );
        movieRepository.deleteById(id);
    }

    @Override
    public MovieResponse update(Long id, MovieRequest movieRequest) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Movie with " + id + " is not found!")
        );
        movie.setName(movieRequest.getName());
        movie.setAuthor(movieRequest.getAuthor());
        movie.setYearOfRelease(movieRequest.getYearOfRelease());
        movieRepository.save(movie);
        MovieResponse movieResponse = new MovieResponse();
        movieResponse.setName(movie.getName());
        movieResponse.setActorToActorResponse(movie.getActors());
        movieResponse.setId(movie.getId());
        movieResponse.setAuthor(movie.getAuthor());
        movieResponse.setYearOfRelease(movie.getYearOfRelease());
        return movieResponse;
    }
}
