package com.softtek.backend.src.presentation.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.backend.src.application.dto.FindAllCheckInDto;
import com.softtek.backend.src.application.usecase.check_in.FindAllCheckInUseCase;
import com.softtek.backend.src.domain.entity.CheckIn;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/checkin")
public class CheckInController {

    @Autowired
    private FindAllCheckInUseCase findAllCheckInUseCase;

    @GetMapping
    public ResponseEntity<List<CheckIn>> findAll(@RequestBody @Valid FindAllCheckInDto dto) {
        var checkIns = this.findAllCheckInUseCase.execute(dto);

        return ResponseEntity.ok(checkIns);
    }
}
