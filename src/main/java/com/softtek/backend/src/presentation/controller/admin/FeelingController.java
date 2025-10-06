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

import com.softtek.backend.src.application.dto.CreateFeelingDto;
import com.softtek.backend.src.application.usecase.feeling.CreateFeelingUseCase;
import com.softtek.backend.src.application.usecase.feeling.DeleteFeelingUseCase;
import com.softtek.backend.src.application.usecase.feeling.FindAllFeelingUseCase;
import com.softtek.backend.src.application.usecase.feeling.FindFeelingByIdUseCase;
import com.softtek.backend.src.domain.entity.Feeling;

@RestController
@RequestMapping("/feeling")
public class FeelingController {

    @Autowired
    private FindAllFeelingUseCase findAllFeelingUseCase;

    @Autowired
    private FindFeelingByIdUseCase findFeelingByIdUseCase;

    @Autowired
    private CreateFeelingUseCase createFeelingUseCase;

    @Autowired
    private DeleteFeelingUseCase deleteFeelingUseCase;

    @GetMapping
    public ResponseEntity<List<Feeling>> findAll() {
        var feelings = this.findAllFeelingUseCase.execute(null);

        return ResponseEntity.ok(feelings);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Feeling> findById(@PathVariable String id) {
        var feeling = this.findFeelingByIdUseCase.execute(id);

        return feeling
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody CreateFeelingDto dto) {
        this.createFeelingUseCase.execute(dto);

        return ResponseEntity.created(null).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        this.deleteFeelingUseCase.execute(id);

        return ResponseEntity.noContent().build();
    }
}
