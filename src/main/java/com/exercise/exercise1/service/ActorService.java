package com.exercise.exercise1.service;

import com.exercise.exercise1.dto.request.ActorRequest;
import com.exercise.exercise1.dto.response.ActorResponse;
import com.exercise.exercise1.dto.response.MovieResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public interface ActorService {
    ActorResponse create(Long movieId, ActorRequest actorRequest);
    Set<ActorResponse> getAllActors();
    Set<ActorResponse> getActorsByMovieId(Long id);
    ActorResponse getActorById(Long id);
    Set<MovieResponse> getAllMoviesByActorId(Long id);
    void deleteActorFromMovie(Long movieId, Long actorId);
    ActorResponse updateActor(Long id, ActorRequest actorRequest);
}
