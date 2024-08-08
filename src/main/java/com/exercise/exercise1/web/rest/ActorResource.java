package com.exercise.exercise1.web.rest;

import com.exercise.exercise1.dto.request.ActorRequest;
import com.exercise.exercise1.dto.response.ActorResponse;
import com.exercise.exercise1.dto.response.MovieResponse;
import com.exercise.exercise1.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/")
public class ActorResource {
    @Autowired
    private ActorService actorService;

    //    Get all actors
    @GetMapping("/actors")
    public Set<ActorResponse> getAllActors() {
        return actorService.getAllActors();
    }

    //    Get actors by movie id
    @GetMapping("/actors/{movieId}")
    public Set<ActorResponse> getActorsByMovieId(@PathVariable Long movieId) {
        return actorService.getActorsByMovieId(movieId);
    }

    //    Get actors by id
    @GetMapping("/actors/actor/{id}")
    public ActorResponse getActorById(@PathVariable Long id) {
        return actorService.getActorById(id);
    }

    //    Get all movies by actor id
    @GetMapping("/actors/{id}/movies")
    public Set<MovieResponse> getAllMoviesByActorId(@PathVariable Long id) {
        return actorService.getAllMoviesByActorId(id);
    }

    //    create a actor by movie id
    @PostMapping("/movies/{movieId}/actors")
    public ActorResponse create(@PathVariable Long movieId, @RequestBody ActorRequest actorRequest) {
        return actorService.create(movieId, actorRequest);
    }

    //    update a actor
    @PutMapping("/actors/{id}")
    public ActorResponse updateActor(@PathVariable Long id, @RequestBody ActorRequest actorRequest) {
        return actorService.updateActor(id, actorRequest);
    }

    //Delete actor from movie
    @DeleteMapping("movies/{movieId}/actors/{actorId}")
    public void deleteActorFromMovie(@PathVariable Long movieId, @PathVariable Long actorId) {
        actorService.deleteActorFromMovie(movieId, actorId);
    }


}
