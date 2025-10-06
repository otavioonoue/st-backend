package com.softtek.backend.src.presentation.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
public class LoginUserDto {
    @Size(min = 3, max = 255)
    @NotBlank
    public String username;
    
    @Size(min = 8, max = 255)
    @NotBlank
    public String password;
}