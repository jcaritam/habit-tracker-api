package com.jcarita.habittrackerapi.habit.dto;

import java.util.UUID;

public record HabitResponseDto (UUID habitId, String name, String description) {
}
