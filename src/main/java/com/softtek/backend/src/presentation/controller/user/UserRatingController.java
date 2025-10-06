package com.softtek.backend.src.presentation.controller.user;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.backend.src.application.dto.SafeRating;
import com.softtek.backend.src.application.mapper.ApplicationMapper;
import com.softtek.backend.src.application.usecase.rating.FindAllRatingUseCase;
import com.softtek.backend.src.application.usecase.rating.FindByIdRatingUseCase;

@RestController
@RequestMapping("/ratings")
public class UserRatingController {
    @Autowired
    private FindAllRatingUseCase findAllRatingUseCase;

    @Autowired
    private FindByIdRatingUseCase findByIdRatingUseCase;

    @GetMapping
    public ResponseEntity<List<SafeRating>> findAll() {
        var safeRatings = this.findAllRatingUseCase.execute(null).stream()
            .map(ApplicationMapper::toSafe)
            .collect(Collectors.toList());
        return ResponseEntity.ok(safeRatings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<SafeRating> findById(@PathVariable String id) {
        return this.findByIdRatingUseCase.execute(id)
            .map(ApplicationMapper::toSafe)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
