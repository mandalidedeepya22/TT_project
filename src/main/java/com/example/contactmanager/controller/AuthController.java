package com.example.contactmanager.controller;

import com.example.contactmanager.model.User;
import com.example.contactmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public Map<String, Object> login(@RequestBody LoginRequest loginRequest) {
        Map<String, Object> response = new HashMap<>();
        
        Optional<User> userOpt = userRepository.findByUsername(loginRequest.getUsername());
        
        if (userOpt.isPresent()) {
            User user = userOpt.get();
            if (user.getPassword().equals(loginRequest.getPassword())) {
                response.put("success", true);
                response.put("message", "Login successful");
                response.put("user", user);
                return response;
            }
        }
        
        response.put("success", false);
        response.put("message", "Invalid username or password");
        return response;
    }

    @PostMapping("/register")
    public Map<String, Object> register(@RequestBody RegisterRequest registerRequest) {
        Map<String, Object> response = new HashMap<>();
        
        // Check if username already exists
        if (userRepository.findByUsername(registerRequest.getUsername()).isPresent()) {
            response.put("success", false);
            response.put("message", "Username already exists");
            return response;
        }
        
        // Create new user
        User newUser = new User(
            registerRequest.getUsername(),
            registerRequest.getPassword(),
            registerRequest.getName()
        );
        
        User savedUser = userRepository.save(newUser);
        
        response.put("success", true);
        response.put("message", "Registration successful");
        response.put("user", savedUser);
        return response;
    }

    // Request classes for login and register
    public static class LoginRequest {
        private String username;
        private String password;

        // Getters and setters
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
    }

    public static class RegisterRequest {
        private String username;
        private String password;
        private String name;

        // Getters and setters
        public String getUsername() { return username; }
        public void setUsername(String username) { this.username = username; }
        public String getPassword() { return password; }
        public void setPassword(String password) { this.password = password; }
        public String getName() { return name; }
        public void setName(String name) { this.name = name; }
    }
}