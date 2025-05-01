package com.jcarita.habittrackerapi.user.service;

import com.jcarita.habittrackerapi.user.dto.UserRequest;
import com.jcarita.habittrackerapi.user.dto.UserResponse;
import com.jcarita.habittrackerapi.user.model.User;
import com.jcarita.habittrackerapi.user.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public Mono<UserResponse> create(UserRequest userRequest) {

        User user = User.builder()
                .name(userRequest.name())
                .email(userRequest.email())
                .build();

        return userRepository.save(user)
                .map(saved -> new UserResponse(saved.getUserId(), saved.getName(), saved.getEmail()));
    }

    @Override
    public Flux<UserResponse> getAllUsers() {
        return userRepository.findAll()
                .map( user -> new UserResponse(
                        user.getUserId(),
                        user.getName(),
                        user.getEmail()
                ));
    }

    @Override
    public Mono<UserResponse> getUserById(UUID userId) {
        return userRepository.findById(userId)
                .map( user -> new UserResponse(
                        user.getUserId(),
                        user.getName(),
                        user.getEmail()
                ));
    }
}
