package com.jcarita.habittrackerapi.habit.service;

import com.jcarita.habittrackerapi.habit.dto.CreateHabitDto;
import com.jcarita.habittrackerapi.habit.dto.HabitResponseDto;
import com.jcarita.habittrackerapi.habit.model.Habit;
import com.jcarita.habittrackerapi.habit.repository.IHabitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class HabitService implements IHabitService {

    private final IHabitRepository habitRepository;

    @Override
    public Mono<HabitResponseDto> add(CreateHabitDto createHabitDto) {

        Habit createHabit = Habit.builder()
                .name(createHabitDto.name())
                .description(createHabitDto.description())
                .userId(createHabitDto.userId())
                .build();

        return habitRepository.save(createHabit)
                .map( habitSaved -> new HabitResponseDto(
                        habitSaved.getHabitId(),
                        habitSaved.getName(),
                        habitSaved.getDescription()
                ));
    }

    @Override
    public Flux<HabitResponseDto> getHabitsByUserId(UUID userId) {
        return habitRepository.findAllByUserId(userId)
                .map(habit -> new HabitResponseDto(
                        habit.getUserId(),
                        habit.getName(),
                        habit.getDescription()
                ));
    }

    @Override
    public Mono<Void> deleteHabitById(UUID id) {
        return habitRepository.findById(id)
                .switchIfEmpty(Mono.error(new RuntimeException("Habit not found")))
                .flatMap(habit -> habitRepository.deleteById(habit.getHabitId()));
    }
}
