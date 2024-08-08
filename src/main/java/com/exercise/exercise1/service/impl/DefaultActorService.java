package com.exercise.exercise1.service.impl;

import com.exercise.exercise1.dto.request.ActorRequest;
import com.exercise.exercise1.dto.response.ActorResponse;
import com.exercise.exercise1.dto.response.MovieResponse;
import com.exercise.exercise1.entity.Actor;
import com.exercise.exercise1.entity.Movie;
import com.exercise.exercise1.exception.NotFoundException;
import com.exercise.exercise1.repository.ActorRepository;
import com.exercise.exercise1.repository.MovieRepository;
import com.exercise.exercise1.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.stream.Collectors;

@Service
public class DefaultActorService implements ActorService {
    @Autowired
    private ActorRepository actorRepository;

    @Autowired
    private MovieRepository movieRepository;

    @Override
    public ActorResponse create(Long movieId, ActorRequest actorRequest) {
        Actor actor = movieRepository.findById(movieId).map(
                        movie1 -> {
                            Long actorId = actorRequest.getId();
                            if (actorId != 0L) {
                                Actor _actor = actorRepository.findById(actorId).orElseThrow(() -> new NotFoundException(
                                        "Actor with " + actorRequest.getId() + " is not found!"
                                ));
                                movie1.getActors().add(_actor);
                                movieRepository.save(movie1);
                                return _actor;
                            }
                            Actor _actor = new Actor(actorRequest.getName());
                            movie1.getActors().add(_actor);
                            actorRepository.save(_actor);
                            return _actor;
                        }
                )
                .orElseThrow(() -> new NotFoundException(
                        "Movie with " + movieId + " is not found!"
                ));
        ActorResponse actorResponse = new ActorResponse();
        actorResponse.setId(actor.getId());
        actorResponse.setName(actor.getName());
        return actorResponse;
    }

    @Override
    public Set<ActorResponse> getAllActors() {
        Set<ActorResponse> actors = new HashSet<>();
        actorRepository.findAll().forEach(
                item -> {
                    ActorResponse actorResponse = new ActorResponse();
                    actorResponse.setId(item.getId());
                    actorResponse.setName(item.getName());
                    actors.add(actorResponse);
                }
        );
        return actors;
    }

    @Override
    public Set<ActorResponse> getActorsByMovieId(Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Movie with " + id + " is not found!"
        ));
        Set<ActorResponse> actors = new HashSet<>();
        movie.getActors().forEach(
                actor -> {
                    ActorResponse actorResponse = new ActorResponse();
                    actorResponse.setId(actor.getId());
                    actorResponse.setName(actor.getName());
                    actors.add(actorResponse);
                }
        );
        return actors;
    }

    @Override
    public ActorResponse getActorById(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Actor with " + id + " is not found"
        ));
        ActorResponse actorResponse = new ActorResponse();
        actorResponse.setId(actor.getId());
        actorResponse.setName(actor.getName());
        return actorResponse;
    }

    @Override
    public Set<MovieResponse> getAllMoviesByActorId(Long id) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Actor with " + id + " is not found!"
        ));
        Set<MovieResponse> movies = new HashSet<>();
        AtomicBoolean check = new AtomicBoolean(false);
        movies = movieRepository.findAll().stream().map(
                movie -> {
                    movie.getActors().forEach(
                            item -> {
                                if (item.getId() == id) {
                                    check.set(true);
                                }
                            }
                    );
                    MovieResponse movieResponse = new MovieResponse();
                    if (check.get()) {
                        check.set(false);
                        movieResponse.setId(movie.getId());
                        movieResponse.setName(movie.getName());
                        movieResponse.setYearOfRelease(movie.getYearOfRelease());
                        movieResponse.setAuthor(movie.getAuthor());
                        movieResponse.setActorToActorResponse(movie.getActors());
                        return movieResponse;
                    } else return null;
                }
        ).collect(Collectors.toSet());
        movies.remove(null);
        return movies;
    }

    @Override
    public void deleteActorFromMovie(Long movieId, Long actorId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(() -> new NotFoundException(
                "Movie with " + movieId + " is not found!"
        ));
        Actor actor = actorRepository.findById(actorId).orElseThrow(() -> new NotFoundException(
                "Actor with " + actorId + " is not found!"
        ));
        movie.getActors().remove(actor);
        movieRepository.save(movie);
    }

    @Override
    public ActorResponse updateActor(Long id, ActorRequest actorRequest) {
        Actor actor = actorRepository.findById(id).orElseThrow(() -> new NotFoundException(
                "Actor with " + id + " is not found!"
        ));
        actor.setName(actorRequest.getName());
        actorRepository.save(actor);
        ActorResponse actorResponse = new ActorResponse();
        actorResponse.setId(actor.getId());
        actorResponse.setName(actor.getName());
        return actorResponse;
    }
}
