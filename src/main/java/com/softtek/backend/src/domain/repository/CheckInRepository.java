package com.softtek.backend.src.domain.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import com.softtek.backend.src.domain.entity.CheckIn;

public interface CheckInRepository {
    Optional<CheckIn> findByUserIdAndCheckinAtBetween(String userId, LocalDateTime startOfDay, LocalDateTime endOfDay);
    List<CheckIn> findAllCheckInByUserId(String userId, LocalDateTime startTime, LocalDateTime endTime);
    CheckIn save(CheckIn checkIn);

    List<CheckIn> findAll(LocalDateTime startTime, LocalDateTime endTime);
}
