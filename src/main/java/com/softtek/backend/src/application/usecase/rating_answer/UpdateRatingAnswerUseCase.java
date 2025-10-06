package com.softtek.backend.src.application.usecase.rating_answer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.UpdateRatingAnswerDto;
import com.softtek.backend.src.application.exception.RatingAnswerNotFoundException;
import com.softtek.backend.src.domain.repository.RatingAnswerRepository;
import com.softtek.backend.src.domain.repository.RatingRepository;
import com.softtek.backend.src.domain.service.RatingService;
import com.softtek.backend.src.domain.type.RiskLevel;
import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UpdateRatingAnswerUseCase implements UseCase<UpdateRatingAnswerDto, Void> {

    @Autowired
    private RatingAnswerRepository ratingAnswerRepository;

    @Autowired
    private RatingService ratingService;

    @Autowired RatingRepository ratingRepository;

    @Override
    public Void execute(UpdateRatingAnswerDto input) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails user = (CustomUserDetails) authentication.getPrincipal();
        
        var ratingAnswerOptional = this.ratingAnswerRepository.findById(input.ratingAnswerId);
        
        if (ratingAnswerOptional.isEmpty()) {
            throw new RatingAnswerNotFoundException();
        }

        var ratingAnswer = ratingAnswerOptional.get();

        if (!ratingAnswer.getUserId().equals(user.getUser().getId())) {
            throw new AccessDeniedException(null);
        }

        var ratingOptional = this.ratingRepository.findById(ratingAnswer.getRatingId());
        var rating = ratingOptional.get();

        var score = this.ratingService.calculateScore(rating, input.answers);
        var riskLevel = this.ratingService.calculateRisk(score, rating.getQuestions().size());
        var progress = this.ratingService.calculateProgressPercentage(rating, input.answers);
        
        ratingAnswer.updateFromCalculation(
            input.answers, 
            score, 
            riskLevel, 
            progress
        );

        log.info("[INFO] There an Rating Answer (" + ratingAnswer.getId() + ") updated.");
        log.info("[INFO] Score: " + score);

        if (riskLevel == RiskLevel.MODERADO || riskLevel == RiskLevel.AGUDO) {
            log.warn("[WARNING] THIS Rating ANSWER HAVE HIGH RISK LEVEL: " + riskLevel);
        }

        this.ratingAnswerRepository.save(ratingAnswer);

        return null;
    }

}
