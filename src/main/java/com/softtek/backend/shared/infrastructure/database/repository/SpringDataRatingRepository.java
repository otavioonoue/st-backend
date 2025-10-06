package com.softtek.backend.shared.infrastructure.database.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataRating;

public interface SpringDataRatingRepository extends MongoRepository<SpringDataRating, String> {
    List<SpringDataRating> findAllByIdNotIn(List<String> ratingIds);
    List<SpringDataRating> findAllByIdIn(List<String> ratingIds);
}
