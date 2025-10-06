package com.softtek.backend.shared.infrastructure.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataFeeling;

public interface SpringDataFeelingRepository extends MongoRepository<SpringDataFeeling, String> {

}
