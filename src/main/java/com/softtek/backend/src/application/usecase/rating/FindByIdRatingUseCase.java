package com.softtek.backend.src.application.usecase.rating;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.entity.Rating;
import com.softtek.backend.src.domain.repository.RatingRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class FindByIdRatingUseCase implements UseCase<String, Optional<Rating>> {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Optional<Rating> execute(String input) {
        return this.ratingRepository.findById(input);
    }

}
