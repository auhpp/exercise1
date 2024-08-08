package com.exercise.exercise1.dto.response;

import com.exercise.exercise1.entity.Actor;

import java.util.HashSet;
import java.util.Set;

public class MovieResponse {
    private Long id;
    private String name;
    private String author;
    private int yearOfRelease;
    private Set<ActorResponse> actors;

    public MovieResponse() {
        id = 0L;
        name = "";
        author = "";
        actors = new HashSet<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public Set<ActorResponse> getActors() {
        return actors;
    }

    public void setActors(Set<ActorResponse> actors) {
        this.actors = actors;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setActorToActorResponse(Set<Actor> actors) {
        actors.forEach(
                item -> {
                    ActorResponse actorResponse = new ActorResponse();
                    actorResponse.setId(item.getId());
                    actorResponse.setName(item.getName());
                    this.getActors().add(actorResponse);
                }
        );
    }
}
