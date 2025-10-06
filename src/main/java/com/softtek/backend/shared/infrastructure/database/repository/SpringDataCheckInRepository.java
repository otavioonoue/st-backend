package com.softtek.backend.shared.infrastructure.database.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataCheckIn;

public interface SpringDataCheckInRepository extends MongoRepository<SpringDataCheckIn, String> {
    Optional<SpringDataCheckIn> findByUserIdAndCheckInAtBetween(
        String userId,
        LocalDateTime startOfDay,
        LocalDateTime endOfDay
    );

    List<SpringDataCheckIn> findAllByUserIdAndCheckInAtBetween(
        String userId,
        LocalDateTime startTime,
        LocalDateTime endTime
    );

    List<SpringDataCheckIn> findAllByCheckInAtBetween(
        LocalDateTime startTime,
        LocalDateTime endTime
    );
}
