package com.softtek.backend.src.presentation.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.backend.src.application.usecase.rating_answer.FindAllRatingAnswerUseCase;
import com.softtek.backend.src.domain.entity.RatingAnswer;

@RestController
@RequestMapping("/rating-answer")
public class RatingAnswerController {

    @Autowired
    private FindAllRatingAnswerUseCase findAllRatingAnswerUseCase;

    @GetMapping
    public ResponseEntity<List<RatingAnswer>> findAll() {
        var ratingAnswerList = this.findAllRatingAnswerUseCase.execute(null);

        return ResponseEntity.ok(ratingAnswerList);
    }
}
