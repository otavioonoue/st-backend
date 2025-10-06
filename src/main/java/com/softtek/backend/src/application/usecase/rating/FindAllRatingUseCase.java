package com.softtek.backend.src.application.usecase.rating;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.entity.Rating;
import com.softtek.backend.src.domain.repository.RatingRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class FindAllRatingUseCase implements UseCase<Void, List<Rating>> {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public List<Rating> execute(Void input) {
        return this.ratingRepository.findAll();
    }

}
