package com.jcarita.habittrackerapi.habit.dto;

import java.util.UUID;

public record CreateHabitDto (String name, String description, UUID userId) {
}
