package com.example.UserRagisterAndLogIn.controller;

import com.example.UserRagisterAndLogIn.dto.AuthRequest;
import com.example.UserRagisterAndLogIn.exception.RegistrationException;
import com.example.UserRagisterAndLogIn.model.User;
import com.example.UserRagisterAndLogIn.service.JwtService;
import com.example.UserRagisterAndLogIn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private JwtService jwtService;

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody User user) {
        try {
            User registeredUser = userService.registerUser(user);

            return ResponseEntity.ok("User registered successfully.");
        } catch (RegistrationException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Registration failed.");
        }
    }

    @PostMapping("/logIn")
    public ResponseEntity<String> logInUser(@RequestBody AuthRequest authRequest) {
        try {
            if (!userService.userExists(authRequest.getEmail())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found");
            }
            // If authentication is successful, generate and return JWT token
            String token = jwtService.generateToken(authRequest.getEmail());
            return ResponseEntity.ok("login Successfully. your token is--> "+token);
        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid username or password");

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Authentication failed");
        }
    }


}
