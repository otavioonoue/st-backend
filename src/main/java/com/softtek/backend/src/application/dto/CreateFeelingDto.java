package com.softtek.backend.src.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class CreateFeelingDto {
    @NotBlank
    @Size(min = 3, max = 50)
    public String name;
}
