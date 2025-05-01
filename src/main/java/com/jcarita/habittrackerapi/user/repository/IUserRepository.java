package com.jcarita.habittrackerapi.user.repository;

import com.jcarita.habittrackerapi.user.model.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IUserRepository extends ReactiveCrudRepository<User, UUID> {
}
