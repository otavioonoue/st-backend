package com.softtek.backend.src.presentation.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.backend.src.application.dto.CreateRatingAnswerDto;
import com.softtek.backend.src.application.dto.UpdateRatingAnswerDto;
import com.softtek.backend.src.application.usecase.rating_answer.CreateRatingAnswerUseCase;
import com.softtek.backend.src.application.usecase.rating_answer.FindAllRatingAnswerByUserUseCase;
import com.softtek.backend.src.application.usecase.rating_answer.UpdateRatingAnswerUseCase;
import com.softtek.backend.src.domain.entity.RatingAnswer;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/rating-answer")
public class UserRatingAnswerController {

    @Autowired
    private FindAllRatingAnswerByUserUseCase findAllRatingAnswerByUserUseCase;

    @Autowired
    private CreateRatingAnswerUseCase createRatingAnswerUseCase;

    @Autowired
    private UpdateRatingAnswerUseCase updateRatingAnswerUseCase;

    @GetMapping
    public ResponseEntity<List<RatingAnswer>> findAll() {
        var ratingAnswerList = this.findAllRatingAnswerByUserUseCase.execute(null);

        return ResponseEntity.ok(ratingAnswerList);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateRatingAnswerDto dto) {
        this.createRatingAnswerUseCase.execute(dto);

        return ResponseEntity.created(null).build();
    }

    @PatchMapping
    public ResponseEntity<Void> update(@RequestBody @Valid UpdateRatingAnswerDto dto) {
        this.updateRatingAnswerUseCase.execute(dto);

        return ResponseEntity.created(null).build();
    }
}
