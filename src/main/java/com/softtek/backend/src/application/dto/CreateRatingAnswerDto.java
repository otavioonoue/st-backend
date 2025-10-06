package com.softtek.backend.src.application.dto;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CreateRatingAnswerDto {
    @NotBlank
    public String ratingId;
    
    @NotEmpty
    public Map<String, String> answers;
}
