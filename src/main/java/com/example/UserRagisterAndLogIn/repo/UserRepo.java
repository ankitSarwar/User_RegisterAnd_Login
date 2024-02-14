package com.example.UserRagisterAndLogIn.repo;

import com.example.UserRagisterAndLogIn.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User, Long> {
    Optional<Object> findByEmail(String email);

    User findFirstByEmail(String email);

    Optional<Object> findByUsername(String username);
}
