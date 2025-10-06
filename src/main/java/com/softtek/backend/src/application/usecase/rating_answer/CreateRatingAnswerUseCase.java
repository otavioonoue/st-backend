package com.softtek.backend.src.application.usecase.rating_answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.CreateRatingAnswerDto;
import com.softtek.backend.src.application.exception.RatingAnswerAlreadyCreatedException;
import com.softtek.backend.src.application.exception.RatingNotFoundException;
import com.softtek.backend.src.domain.entity.RatingAnswer;
import com.softtek.backend.src.domain.repository.RatingAnswerRepository;
import com.softtek.backend.src.domain.repository.RatingRepository;
import com.softtek.backend.src.domain.service.RatingService;
import com.softtek.backend.src.domain.type.RiskLevel;
import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreateRatingAnswerUseCase implements UseCase<CreateRatingAnswerDto, Void> {

    @Autowired
    private RatingAnswerRepository ratingAnswerRepository;

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingService ratingService;

    @Override
    public Void execute(CreateRatingAnswerDto input) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();

        var rating = this.ratingRepository.findById(input.ratingId);

        if (rating.isEmpty()) {
            throw new RatingNotFoundException();
        }

        var existingAnswer = this.ratingAnswerRepository.findByUserIdAndRatingId(user.getUser().getId(), rating.get().getId());

        if (existingAnswer.isPresent()) {
            throw new RatingAnswerAlreadyCreatedException();
        }

        var score = ratingService.calculateScore(rating.get(), input.answers);
        var risk = ratingService.calculateRisk(score, rating.get().getQuestions().size());
        var progress = ratingService.calculateProgressPercentage(rating.get(), input.answers);

        var ratingAnswer = new RatingAnswer(
            null, 
            user.getUser().getId(), 
            rating.get().getId(), 
            input.answers, 
            score, 
            risk,
            progress
        );

        log.info("[INFO] New rating answer with score: " + score);

        if (risk == RiskLevel.MODERADO || risk == RiskLevel.AGUDO) {
            log.warn("[WARNING] THIS rating ANSWER HAVE HIGH RISK LEVEL: " + risk);
        }

        this.ratingAnswerRepository.save(ratingAnswer);
        return null;
    }
}
