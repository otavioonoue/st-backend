package com.softtek.backend.src.application.dto;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CreateRatingDto {
    @Size(min = 3, max = 255)
    @NotBlank
    public String name;

    @NotEmpty
    public Map<String, QuestionDto> questions;
}
