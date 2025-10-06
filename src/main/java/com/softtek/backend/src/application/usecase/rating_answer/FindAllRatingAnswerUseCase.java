package com.softtek.backend.src.application.usecase.rating_answer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.entity.RatingAnswer;
import com.softtek.backend.src.domain.repository.RatingAnswerRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class FindAllRatingAnswerUseCase implements UseCase<Void, List<RatingAnswer>> {

    @Autowired
    private RatingAnswerRepository ratingAnswerRepository;

    @Override
    public List<RatingAnswer> execute(Void input) {
        return this.ratingAnswerRepository.findAll();
    }

}
