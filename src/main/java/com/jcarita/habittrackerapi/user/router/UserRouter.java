package com.jcarita.habittrackerapi.user.router;

import com.jcarita.habittrackerapi.user.handler.UserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

@Configuration
public class UserRouter {

    @Bean
    public RouterFunction<ServerResponse> route(UserHandler handler) {
        return RouterFunctions.route()
                .GET("/users", handler::getAllUsers)
                .GET("/users/{id}", handler::getUser)
                .POST("/users", handler::createUser)
                .build();
    }
}
