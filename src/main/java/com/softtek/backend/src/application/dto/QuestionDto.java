package com.softtek.backend.src.application.dto;

import java.util.Map;

import com.softtek.backend.src.domain.type.AnswerOption;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class QuestionDto {
    @Size(min = 1, max = 5)
    @NotBlank
    public String key;

    @Size(max = 255)
    @NotBlank
    public String text;

    @NotEmpty
    public Map<String, AnswerOption> alternatives;
}
