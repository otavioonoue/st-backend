package com.softtek.backend.src.domain.repository;

import java.util.List;
import java.util.Optional;

import com.softtek.backend.src.domain.entity.Feeling;

public interface FeelingRepository {
    List<Feeling> findAll();
    Optional<Feeling> findById(String feelingId);
    Feeling save(Feeling feeling);
    void delete(String feelingId);
}
