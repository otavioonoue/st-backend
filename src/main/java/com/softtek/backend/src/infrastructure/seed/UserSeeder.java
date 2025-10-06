package com.softtek.backend.src.infrastructure.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.softtek.backend.src.domain.entity.User;
import com.softtek.backend.src.domain.repository.UserRepository;
import com.softtek.backend.src.domain.type.Role;

@Component
public class UserSeeder implements CommandLineRunner {

    private final UserRepository userRepository;
     private final PasswordEncoder passwordEncoder;

    public UserSeeder(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        if (userRepository.findByUsername("admin").isEmpty()) {
            User admin = new User(
                null,
                "admin",
                passwordEncoder.encode("admin123"),
                Role.ADMIN,
                true
            );

            userRepository.save(admin);
            System.out.println("Admin user created successfully!");
        }
    }

}
