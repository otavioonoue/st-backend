package com.softtek.backend.src.application.usecase.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.CreateRatingDto;
import com.softtek.backend.src.application.mapper.ApplicationMapper;
import com.softtek.backend.src.domain.entity.Rating;
import com.softtek.backend.src.domain.repository.RatingRepository;
import com.softtek.backend.src.domain.service.RatingService;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class CreateRatingUseCase implements UseCase<CreateRatingDto, Void> {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingService ratingService;

    @Override
    public Void execute(CreateRatingDto input) {
        Rating rating = ApplicationMapper.toDomain(input);
        int maxScore = this.ratingService.calculateMaxScore(rating.getQuestions().size());
        
        rating.setMaxScore(maxScore);

        this.ratingRepository.save(rating);
        return null;
    }

}
