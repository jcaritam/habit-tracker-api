package com.jcarita.habittrackerapi.user.dto;

import java.util.UUID;

public record UserResponse (UUID userId, String name, String email) { }
