package com.softtek.backend.src.presentation.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.backend.src.application.usecase.user.FindAllUserUseCase;
import com.softtek.backend.src.domain.entity.User;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private FindAllUserUseCase findAllUseCase;
    
    @GetMapping
    public List<User> findAll() {
        return this.findAllUseCase.execute(null);
    }
}