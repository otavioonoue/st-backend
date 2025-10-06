package com.softtek.backend.src.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.softtek.backend.shared.infrastructure.database.repository.SpringDataRatingRepository;
import com.softtek.backend.src.domain.entity.Rating;
import com.softtek.backend.src.domain.repository.RatingRepository;
import com.softtek.backend.src.infrastructure.mapper.InfrastructureMapper;

@Repository
public class RatingRepositoryImpl implements RatingRepository {

    private final SpringDataRatingRepository repository;

    public RatingRepositoryImpl(SpringDataRatingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Rating save(Rating ratting) {
        var ratting_data = InfrastructureMapper.toData(ratting);
        return InfrastructureMapper.toDomain(this.repository.save(ratting_data));
    }

    @Override
    public List<Rating> findAll() {
        return this.repository.findAll().stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public Optional<Rating> findById(String id) {
        return this.repository.findById(id)
            .map(InfrastructureMapper::toDomain);
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<Rating> findAllByIdNotIn(List<String> ratingIds) {
        var ratingDataIds = this.repository.findAllByIdNotIn(ratingIds);
        
        return ratingDataIds.stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<Rating> findAllByIdIn(List<String> ratingIds) {
        var ratingDataIds = this.repository.findAllByIdIn(ratingIds);
        
        return ratingDataIds.stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

}
