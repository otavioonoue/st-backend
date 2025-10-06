package com.softtek.backend.src.presentation.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.backend.src.application.dto.CreateRatingDto;
import com.softtek.backend.src.application.usecase.rating.CreateRatingUseCase;
import com.softtek.backend.src.application.usecase.rating.DeleteRatingUseCase;
import com.softtek.backend.src.application.usecase.rating.FindAllRatingUseCase;
import com.softtek.backend.src.application.usecase.rating.FindByIdRatingUseCase;
import com.softtek.backend.src.domain.entity.Rating;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/ratings")
public class RatingController {
    @Autowired
    private FindAllRatingUseCase findAllRatingUseCase;

    @Autowired
    private CreateRatingUseCase createRatingUseCase;

    @Autowired
    private DeleteRatingUseCase deleteRatingUseCase;

    @Autowired
    private FindByIdRatingUseCase findByIdRatingUseCase;

    @GetMapping
    public ResponseEntity<List<Rating>> findAll() {
        return ResponseEntity.ok(this.findAllRatingUseCase.execute(null));
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateRatingDto dto) {
        this.createRatingUseCase.execute(dto);
        return ResponseEntity.created(null).build(); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.deleteRatingUseCase.execute(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rating> findById(@PathVariable String id) {
        return this.findByIdRatingUseCase.execute(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
