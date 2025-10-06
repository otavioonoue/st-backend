package com.softtek.backend.src.application.usecase.business_email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.exception.EmailDoesntExistsException;
import com.softtek.backend.src.domain.repository.BusinessEmailRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class DeleteBusinessEmailUseCase implements UseCase<String, Void> {

    @Autowired
    private BusinessEmailRepository businessEmailRepository;

    @Override
    public Void execute(String input) {
        var business_email = this.businessEmailRepository.findByEmail(input);

        if (business_email.isEmpty()) {
            throw new EmailDoesntExistsException();
        }

        this.businessEmailRepository.delete(business_email.get());
        return null;
    }

}
