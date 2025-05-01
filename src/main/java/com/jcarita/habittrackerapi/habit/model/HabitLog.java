package com.jcarita.habittrackerapi.habit.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Table(name = "habit_logs")
@Data
public class HabitLog {

    @Id
    @Column("habit_log_id")
    private UUID id;

    private LocalDateTime date;

    private Boolean completed;

    @Column("habit_id")
    private UUID habitId;
}
