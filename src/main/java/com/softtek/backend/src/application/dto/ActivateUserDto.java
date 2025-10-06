package com.softtek.backend.src.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class ActivateUserDto {
    @NotBlank
    public String token;

    @Size(min = 6, max = 255)
    @NotBlank
    public String businessEmail;
}
