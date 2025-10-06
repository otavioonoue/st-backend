package com.softtek.backend.src.infrastructure.seed;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataBusinessEmail;
import com.softtek.backend.shared.infrastructure.database.repository.SpringDataBusinessEmailRepository;

@Component
public class BusinessEmailSeeder implements CommandLineRunner {

    private final SpringDataBusinessEmailRepository repository;

    public BusinessEmailSeeder(SpringDataBusinessEmailRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        if (repository.count() == 0) {
            SpringDataBusinessEmail email1 = new SpringDataBusinessEmail();
            email1.setEmail("teste1@example.com");
            email1.setUsed(false);

            SpringDataBusinessEmail email2 = new SpringDataBusinessEmail();
            email2.setEmail("otavio.onoue@outlook.com");
            email2.setUsed(false);

            repository.save(email1);
            repository.save(email2);

            System.out.println("Business emails populated succefully!");
        }
    }
}