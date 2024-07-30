package com.exercise.exercise1.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MovieRequest {
    private String name;
    private String author;
    @JsonProperty("year_of_release")
    private int yearOfRelease;

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
}
