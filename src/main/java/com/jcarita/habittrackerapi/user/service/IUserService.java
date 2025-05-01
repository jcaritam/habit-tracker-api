package com.jcarita.habittrackerapi.user.service;

import com.jcarita.habittrackerapi.user.dto.UserRequest;
import com.jcarita.habittrackerapi.user.dto.UserResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface IUserService {
    Mono<UserResponse> create(UserRequest userRequest);
    Flux<UserResponse> getAllUsers();
    Mono<UserResponse> getUserById(UUID userId);
}
