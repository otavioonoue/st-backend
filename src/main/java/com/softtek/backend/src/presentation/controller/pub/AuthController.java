package com.softtek.backend.src.presentation.controller.pub;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.backend.src.application.dto.ActivateUserDto;
import com.softtek.backend.src.application.usecase.authentication.ActivateUserUseCase;
import com.softtek.backend.src.application.usecase.authentication.CreateUserUseCase;
import com.softtek.backend.src.application.usecase.authentication.LoginUserUseCase;
import com.softtek.backend.src.application.usecase.authentication.ValidateTokenUserUseCase;
import com.softtek.backend.src.presentation.dto.AuthResponseDto;
import com.softtek.backend.src.presentation.dto.CreateUserDto;
import com.softtek.backend.src.presentation.dto.LoginUserDto;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private CreateUserUseCase createUserUseCase;

    @Autowired 
    private LoginUserUseCase loginUserUseCase;

    @Autowired
    private ActivateUserUseCase activateUserUseCase;

    @Autowired
    private ValidateTokenUserUseCase validateTokenUserUseCase;

    @PostMapping("/login")
    public ResponseEntity<AuthResponseDto> login(@RequestBody @Valid LoginUserDto dto) {
        var authResponse = this.loginUserUseCase.execute(dto);
        
        return ResponseEntity.ok(authResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<Void> register(@RequestBody @Valid CreateUserDto dto) {
        this.createUserUseCase.execute(dto);
        return ResponseEntity.created(null).build(); 
    }

    @PostMapping("/activate")
    public ResponseEntity<Void> activate(@RequestBody @Valid ActivateUserDto dto) {
        this.activateUserUseCase.execute(dto);
        return ResponseEntity.created(null).build();
    }

    @GetMapping("/validate")
    public ResponseEntity<Boolean> validateToken(@RequestHeader("Authorization") String authHeader) {
        String token = authHeader.replace("Bearer ", "");
        boolean valid = this.validateTokenUserUseCase.execute(token);
        return ResponseEntity.ok(valid);
    }
}
