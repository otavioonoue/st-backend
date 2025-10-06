package com.softtek.backend.src.application.dto;

import java.util.Map;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;

public class UpdateRatingAnswerDto {
    @NotBlank
    public String ratingAnswerId;
    
    @NotEmpty
    public Map<String, String> answers;
}
