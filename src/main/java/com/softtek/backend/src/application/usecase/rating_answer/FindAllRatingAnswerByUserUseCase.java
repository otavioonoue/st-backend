package com.softtek.backend.src.application.usecase.rating_answer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.entity.RatingAnswer;
import com.softtek.backend.src.domain.repository.RatingAnswerRepository;
import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.CustomUserDetails;

@Service
public class FindAllRatingAnswerByUserUseCase implements UseCase<Void, List<RatingAnswer>> {
    
    @Autowired
    private RatingAnswerRepository rattingAnswerRepository;

    @Override
    public List<RatingAnswer> execute(Void input) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String userId = userDetails.getUser().getId();

        var rattingAnswers = this.rattingAnswerRepository.findAllByUserIdAndProgressLessThan(userId, 100);
        
        return rattingAnswers;
    }

    
}
