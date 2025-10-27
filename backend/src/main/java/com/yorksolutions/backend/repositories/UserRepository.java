package com.yorksolutions.backend.repositories;

import com.yorksolutions.backend.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByAuthSub(String authSub);
    Optional<User> findByEmail(String email);
}
