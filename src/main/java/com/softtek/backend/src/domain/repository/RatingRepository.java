package com.softtek.backend.src.domain.repository;

import java.util.List;
import java.util.Optional;

import com.softtek.backend.src.domain.entity.Rating;

public interface RatingRepository {
    Rating save(Rating ratting);
    List<Rating> findAll();
    Optional<Rating> findById(String id);
    void delete(String id);

    List<Rating> findAllByIdNotIn(List<String> ratingIds);
    List<Rating> findAllByIdIn(List<String> ratingIds);
}
