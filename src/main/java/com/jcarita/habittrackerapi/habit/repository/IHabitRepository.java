package com.jcarita.habittrackerapi.habit.repository;

import com.jcarita.habittrackerapi.habit.model.Habit;
import io.micrometer.observation.ObservationFilter;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Repository
public interface IHabitRepository extends ReactiveCrudRepository<Habit, UUID> {
    Flux<Habit> findAllByUserId(UUID userId);
}
