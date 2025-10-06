package com.softtek.backend.src.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.softtek.backend.shared.infrastructure.database.repository.SpringDataRatingAnswerRepository;
import com.softtek.backend.src.domain.entity.RatingAnswer;
import com.softtek.backend.src.domain.repository.RatingAnswerRepository;
import com.softtek.backend.src.infrastructure.mapper.InfrastructureMapper;

@Repository
public class RatingAnswerRepositoryImpl implements RatingAnswerRepository {

    private SpringDataRatingAnswerRepository repository;

    public RatingAnswerRepositoryImpl(SpringDataRatingAnswerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<RatingAnswer> findAll() {
        return this.repository.findAll().stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public RatingAnswer save(RatingAnswer ratingAnswer) {
        var ratingAnswerData = InfrastructureMapper.toData(ratingAnswer);
        return InfrastructureMapper.toDomain(this.repository.save(ratingAnswerData));
    }

    @Override
    public void delete(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public Optional<RatingAnswer> findById(String id) {
        var ratingAnswerData = this.repository.findById(id);

        return ratingAnswerData.map(InfrastructureMapper::toDomain);
    }

    @Override
    public Optional<RatingAnswer> findByUserIdAndRatingId(String userId, String ratingId) {
        var ratingAnswerData = this.repository.findByUserIdAndRatingId(userId, ratingId);
        
        return ratingAnswerData.map(InfrastructureMapper::toDomain);
    }

    
    @Override
    public List<RatingAnswer> findAllByUserIdAndProgressLessThan(String userId, double progress) {
        var ratingAnswersData = this.repository.findAllByUserIdAndProgressLessThan(userId, progress);
        
        return ratingAnswersData.stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public List<RatingAnswer> findAllByUserIdAndProgressLessThanAndRatingIdNot(String userId, int progress,
            String ratingId) {
        var ratingAnswersData = this.repository.findAllByUserIdAndProgressLessThanAndRatingIdNot(userId, progress, ratingId);
        
        return ratingAnswersData.stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

}
