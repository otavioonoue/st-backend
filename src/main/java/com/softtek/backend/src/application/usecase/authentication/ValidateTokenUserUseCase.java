package com.softtek.backend.src.application.usecase.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.TokenService;

@Service
public class ValidateTokenUserUseCase implements UseCase<String, Boolean> {

    @Autowired
    private TokenService tokenService;

    @Override
    public Boolean execute(String input) {
        try {
            this.tokenService.validateToken(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
