package com.exercise.exercise1.dto.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotEmpty;

public class ActorRequest {
    private Long id;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        if (id == null){
            id = 0L;
        }
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
