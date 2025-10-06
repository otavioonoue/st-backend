package com.softtek.backend.shared.infrastructure.database.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataUser;

public interface SpringDataUserRepository extends MongoRepository<SpringDataUser, String> {
	Optional<SpringDataUser> findByUsername(String username);
}