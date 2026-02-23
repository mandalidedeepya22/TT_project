package com.example.contactmanager.config;

import com.example.contactmanager.model.User;
import com.example.contactmanager.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final UserRepository userRepository;

    public DataInitializer(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create default admin user if it doesn't exist
        if (userRepository.findByUsername("admin").isEmpty()) {
            User adminUser = new User("admin", "admin123", "Administrator");
            userRepository.save(adminUser);
            System.out.println("Default admin user created:");
            System.out.println("Username: admin");
            System.out.println("Password: admin123");
        }
    }
}