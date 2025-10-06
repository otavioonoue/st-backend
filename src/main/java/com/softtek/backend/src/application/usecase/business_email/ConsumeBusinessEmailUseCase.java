package com.softtek.backend.src.application.usecase.business_email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.exception.EmailAlreadyUsedException;
import com.softtek.backend.src.application.exception.EmailDoesntExistsException;
import com.softtek.backend.src.domain.repository.BusinessEmailRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class ConsumeBusinessEmailUseCase implements UseCase<String, Void> {
    @Autowired
    private BusinessEmailRepository businessEmailRepository;

    @Override
    public Void execute(String input) {
        var email = this.businessEmailRepository.findByEmail(input);

        if (email.isEmpty()) {
            throw new EmailDoesntExistsException();
        } 

        if (email.get().getIsUsed()) {
            throw new EmailAlreadyUsedException();
        }

        email.get().setIsUsed(true);

        this.businessEmailRepository.save(email.get());

        return null;
    }
}
