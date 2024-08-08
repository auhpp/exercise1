package com.exercise.exercise1.repository;

import com.exercise.exercise1.entity.Actor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorRepository extends JpaRepository<Actor, Long> {
}
