package com.softtek.backend.src.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class AnswerOptionDto {
    @Size(max = 50)
    @NotBlank
    public String optionText;

    @NotBlank
    public int points;
}
