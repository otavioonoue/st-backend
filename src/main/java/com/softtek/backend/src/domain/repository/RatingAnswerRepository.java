package com.softtek.backend.src.domain.repository;

import java.util.List;
import java.util.Optional;

import com.softtek.backend.src.domain.entity.RatingAnswer;

public interface RatingAnswerRepository {
    List<RatingAnswer> findAll();
    RatingAnswer save(RatingAnswer ratingAnswer);
    void delete(String id);
    Optional<RatingAnswer> findById(String id);
    Optional<RatingAnswer> findByUserIdAndRatingId(String userId, String ratingId);
    
    List<RatingAnswer> findAllByUserIdAndProgressLessThan(String userId, double progress);
    List<RatingAnswer> findAllByUserIdAndProgressLessThanAndRatingIdNot(
        String userId, int progress, String ratingId);
}
