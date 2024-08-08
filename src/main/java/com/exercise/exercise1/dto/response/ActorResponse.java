package com.exercise.exercise1.dto.response;

import com.exercise.exercise1.entity.Movie;

import java.util.Set;

public class ActorResponse {
    private Long id;
    private String name;

    public ActorResponse() {
        id = 0L;
        name = "";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
