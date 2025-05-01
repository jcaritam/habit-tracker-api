package com.jcarita.habittrackerapi.user.handler;

import com.jcarita.habittrackerapi.user.dto.UserRequest;
import com.jcarita.habittrackerapi.user.dto.UserResponse;
import com.jcarita.habittrackerapi.user.model.User;
import com.jcarita.habittrackerapi.user.repository.IUserRepository;
import com.jcarita.habittrackerapi.user.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Component
@RequiredArgsConstructor
public class UserHandler {

    private final IUserService userService;

    public Mono<ServerResponse> getAllUsers(ServerRequest req) {
        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(userService.getAllUsers(), UserResponse.class);
    }

    public Mono<ServerResponse> createUser(ServerRequest req) {
        return req.bodyToMono(UserRequest.class)
                .flatMap(userService::create)
                .flatMap(userResponse -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(userResponse));
    }

    public Mono<ServerResponse> getUser(ServerRequest req) {
        UUID userId = UUID.fromString(req.pathVariable("id"));

        return userService.getUserById(userId)
                .flatMap( user -> ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .bodyValue(user))
                .switchIfEmpty(ServerResponse.notFound().build());
    }
}
