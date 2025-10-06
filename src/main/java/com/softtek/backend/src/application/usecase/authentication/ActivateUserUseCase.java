package com.softtek.backend.src.application.usecase.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.ActivateUserDto;
import com.softtek.backend.src.application.usecase.business_email.ConsumeBusinessEmailUseCase;
import com.softtek.backend.src.domain.repository.UserRepository;
import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.TokenService;

@Service
public class ActivateUserUseCase implements UseCase<ActivateUserDto, Void> {
    
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ConsumeBusinessEmailUseCase consumeBusinessEmailUseCase;

    @Autowired
    private TokenService tokenService;

    @Override
    public Void execute(ActivateUserDto input) {
        var username = this.tokenService.validateRegisterToken(input.token);
        var user = this.userRepository.findByUsername(username);

        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }

        this.consumeBusinessEmailUseCase.execute(input.businessEmail);

        user.get().setActive(true);

        this.userRepository.save(user.get());

        return null;
    }
}
