package com.softtek.backend.src.infrastructure.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.softtek.backend.shared.infrastructure.database.repository.SpringDataCheckInRepository;
import com.softtek.backend.src.domain.entity.CheckIn;
import com.softtek.backend.src.domain.repository.CheckInRepository;
import com.softtek.backend.src.infrastructure.mapper.InfrastructureMapper;

@Repository
public class CheckInRepositoryImpl implements CheckInRepository {

    private final SpringDataCheckInRepository repository;

    public CheckInRepositoryImpl(SpringDataCheckInRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<CheckIn> findByUserIdAndCheckinAtBetween(String userId, LocalDateTime startOfDay,
            LocalDateTime endOfDay) {
        var checkInDomain = this.repository.findByUserIdAndCheckInAtBetween(userId, startOfDay, endOfDay)
            .map(InfrastructureMapper::toDomain);
        
        return checkInDomain;
    }

    @Override
    public List<CheckIn> findAllCheckInByUserId(String userId, LocalDateTime startTime, LocalDateTime endTime) {
        var checkInsData = this.repository.findAllByUserIdAndCheckInAtBetween(userId, startTime, endTime);

        return checkInsData.stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public CheckIn save(CheckIn checkIn) {
        var checkInDomain = this.repository.save(InfrastructureMapper.toData(checkIn));

        return InfrastructureMapper.toDomain(checkInDomain);
    }

    @Override
    public List<CheckIn> findAll(LocalDateTime startTime, LocalDateTime endTime) {
        var checkInsData = this.repository.findAllByCheckInAtBetween(startTime, endTime);
        
        return checkInsData.stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }
}
