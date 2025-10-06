package com.softtek.backend.src.application.usecase.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.CustomUserDetails;
import com.softtek.backend.src.infrastructure.security.TokenService;
import com.softtek.backend.src.presentation.dto.AuthResponseDto;
import com.softtek.backend.src.presentation.dto.LoginUserDto;

@Service
public class LoginUserUseCase implements UseCase<LoginUserDto, AuthResponseDto> {
    
    @Autowired
    private TokenService tokenService;
    
    @Autowired
    private AuthenticationManager authenticationManager;

    @Override
    public AuthResponseDto execute(LoginUserDto input) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(input.username, input.password);
        
        var auth = this.authenticationManager.authenticate(usernamePassword);
        var userDetails = (CustomUserDetails) auth.getPrincipal();
        var token = this.tokenService.generateToken(userDetails.getUser());

        return new AuthResponseDto(token);
    }

}
