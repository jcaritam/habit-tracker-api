package com.jcarita.habittrackerapi.habit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Table(name = "habits")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Habit{

    @Id
    @Column("habit_id")
    private UUID habitId;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

    @Column("user_id")
    private UUID userId;
}
