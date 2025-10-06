package com.softtek.backend.src.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.softtek.backend.shared.infrastructure.database.repository.SpringDataFeelingRepository;
import com.softtek.backend.src.domain.entity.Feeling;
import com.softtek.backend.src.domain.repository.FeelingRepository;
import com.softtek.backend.src.infrastructure.mapper.InfrastructureMapper;

@Repository
public class FeelingRepositoryImpl implements FeelingRepository {

    private final SpringDataFeelingRepository repository;

    public FeelingRepositoryImpl(SpringDataFeelingRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Feeling> findAll() {
        var feelings = this.repository.findAll();
        return feelings.stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Feeling> findById(String feelingId) {
        var feeling = this.repository.findById(feelingId);
        return feeling.map(InfrastructureMapper::toDomain);
    }

    @Override
    public Feeling save(Feeling feeling) {
        var feelingData = InfrastructureMapper.toData(feeling);
        return InfrastructureMapper.toDomain(this.repository.save(feelingData));
    }

    @Override
    public void delete(String feelingId) {
        this.repository.deleteById(feelingId);
    }
}
