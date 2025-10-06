package com.softtek.backend.src.presentation.controller.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.backend.src.application.dto.CreateCheckInDto;
import com.softtek.backend.src.application.dto.FindAllCheckInDto;
import com.softtek.backend.src.application.usecase.check_in.CreateCheckInUseCase;
import com.softtek.backend.src.application.usecase.check_in.FindAllCheckInUserUseCase;
import com.softtek.backend.src.domain.entity.CheckIn;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/checkin")
public class UserCheckInController {

    @Autowired
    private CreateCheckInUseCase createCheckInUseCase;
    
    @Autowired
    private FindAllCheckInUserUseCase findAllCheckInUserUseCase;

    @GetMapping()
    public ResponseEntity<List<CheckIn>> findAll(@RequestBody @Valid FindAllCheckInDto dto) {
        var checkIns = this.findAllCheckInUserUseCase.execute(dto);
        return ResponseEntity.ok(checkIns);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateCheckInDto dto) {
        this.createCheckInUseCase.execute(dto);
        return ResponseEntity.created(null).build();
    }
}
