package com.softtek.backend.src.application.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CreateCheckInDto {
    @NotBlank
    public String feelingId;
}
