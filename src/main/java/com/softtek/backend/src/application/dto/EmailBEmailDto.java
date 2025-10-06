package com.softtek.backend.src.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class EmailBEmailDto {
    @Size(min = 6, max = 255)
    @NotBlank
    public String email;
}
