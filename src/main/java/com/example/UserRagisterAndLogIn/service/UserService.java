package com.example.UserRagisterAndLogIn.service;

import com.example.UserRagisterAndLogIn.exception.RegistrationException;
import com.example.UserRagisterAndLogIn.model.User;
import com.example.UserRagisterAndLogIn.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    @Autowired
    UserRepo userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            throw new RegistrationException("Username already exists");
        }
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new RegistrationException("Email address is already registered");
        }

        // Hash and store the password securely
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save the user
        User registeredUser = userRepository.save(user);

        return registeredUser;
    }

    public boolean userExists(String email) {
        return userRepository.findByEmail(email) != null;
    }
}
