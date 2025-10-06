package com.softtek.backend.shared.infrastructure.database.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataRatingAnswer;

public interface SpringDataRatingAnswerRepository extends MongoRepository<SpringDataRatingAnswer, String> {
    Optional<SpringDataRatingAnswer> findByUserIdAndRatingId(String userId, String ratingId);
    List<SpringDataRatingAnswer> findAllByUserIdAndProgressLessThan(String userId, double progress);
    List<SpringDataRatingAnswer> findAllByUserIdAndProgressLessThanAndRatingIdNot(
        String userId, int progress, String ratingId);

}
