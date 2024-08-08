package com.exercise.exercise1.repository;

import com.exercise.exercise1.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
