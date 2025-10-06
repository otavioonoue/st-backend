package com.softtek.backend.src.application.dto;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class FindAllCheckInDto {
    @NotNull
    public LocalDateTime startTime;
    
    @NotNull
    public LocalDateTime endTime;
}
