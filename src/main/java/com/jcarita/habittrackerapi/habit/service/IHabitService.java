package com.jcarita.habittrackerapi.habit.service;

import com.jcarita.habittrackerapi.habit.dto.CreateHabitDto;
import com.jcarita.habittrackerapi.habit.dto.HabitResponseDto;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface IHabitService {
    Mono<HabitResponseDto> add(CreateHabitDto createHabitDto);
    Flux<HabitResponseDto> getHabitsByUserId(UUID userId);
    Mono<Void> deleteHabitById(UUID id);
}
