package com.softtek.backend.shared.infrastructure.database.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataBusinessEmail;

public interface SpringDataBusinessEmailRepository extends MongoRepository<SpringDataBusinessEmail, String> {
    Optional<SpringDataBusinessEmail> findByEmail(String email);
}
