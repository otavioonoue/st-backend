package com.softtek.backend.src.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class SafeUser {
    @Size(min = 3, max = 255)
    @NotBlank
    public String username;

    @Size(min = 3, max = 100)
    @NotBlank
    public String password;
}