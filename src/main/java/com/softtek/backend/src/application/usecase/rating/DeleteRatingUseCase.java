package com.softtek.backend.src.application.usecase.rating;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.exception.RatingNotFoundException;
import com.softtek.backend.src.domain.repository.RatingRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class DeleteRatingUseCase implements UseCase<String, Void> {

    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Void execute(String input) {

        var rating = this.ratingRepository.findById(input);   
        
        if (rating.isEmpty()) {
            throw new RatingNotFoundException();
        }

        this.ratingRepository.delete(rating.get().getId());
        return null;
    }

}
