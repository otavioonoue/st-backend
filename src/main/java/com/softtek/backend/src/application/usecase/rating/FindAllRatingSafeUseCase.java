package com.softtek.backend.src.application.usecase.rating;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.SafeRating;
import com.softtek.backend.src.application.mapper.ApplicationMapper;
import com.softtek.backend.src.domain.entity.Rating;
import com.softtek.backend.src.domain.repository.RatingAnswerRepository;
import com.softtek.backend.src.domain.repository.RatingRepository;
import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.CustomUserDetails;

@Service
public class FindAllRatingSafeUseCase implements UseCase<Void, List<SafeRating>> {

    @Autowired
    private RatingRepository ratingRepository;

    @Autowired
    private RatingAnswerRepository ratingAnswerRepository;

    @Override
    public List<SafeRating> execute(Void input) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        String userId = userDetails.getUser().getId();

        var ratingAnswer = this.ratingAnswerRepository.findAllByUserIdAndProgressLessThan(userId, 100);
        List<String> ratingAnswerIds = ratingAnswer.stream()
            .map(r -> r.getRatingId())
            .toList();
        
        var ratingNotStarted = this.ratingRepository.findAllByIdNotIn(ratingAnswerIds);
        var ratingAlreadyStarted = this.ratingRepository.findAllByIdIn(ratingAnswerIds);
        List<Rating> combined = new ArrayList<Rating>(ratingAlreadyStarted);
        combined.addAll(ratingNotStarted);

        return combined.stream()
            .map(ApplicationMapper::toSafe)
            .collect(Collectors.toList());
    }

}
