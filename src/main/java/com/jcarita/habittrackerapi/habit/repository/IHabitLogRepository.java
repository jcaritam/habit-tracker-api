package com.jcarita.habittrackerapi.habit.repository;

import com.jcarita.habittrackerapi.habit.model.HabitLog;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IHabitLogRepository extends ReactiveCrudRepository<HabitLog, UUID> { }
