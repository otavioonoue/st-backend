package com.softtek.backend.src.infrastructure.seed;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataFeeling;
import com.softtek.backend.shared.infrastructure.database.repository.SpringDataFeelingRepository;

@Configuration
public class FeelingSeeder {
    @Bean
    CommandLineRunner seedFeelings(SpringDataFeelingRepository repository) {
        return args -> {
            if (repository.count() == 0) {
                repository.saveAll(List.of(
                    new SpringDataFeeling(null, "Alegria"),
                    new SpringDataFeeling(null, "Tristeza"),
                    new SpringDataFeeling(null, "Medo"),
                    new SpringDataFeeling(null, "Raiva"),
                    new SpringDataFeeling(null, "Surpresa"),
                    new SpringDataFeeling(null, "Nojo")
                ));
                System.out.println("Feelings populated succefully!");
            }
        };
    }
}
