package com.softtek.backend.src.application.usecase.business_email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.EmailBEmailDto;
import com.softtek.backend.src.application.exception.EmailAlreadyExistsException;
import com.softtek.backend.src.domain.entity.BusinessEmail;
import com.softtek.backend.src.domain.repository.BusinessEmailRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class CreateBusinessEmailUseCase implements UseCase<EmailBEmailDto, Void> {

    @Autowired
    private BusinessEmailRepository businessEmailRepository;

    @Override
    public Void execute(EmailBEmailDto input) {
        var business_email = this.businessEmailRepository.findByEmail(input.email);

        if (business_email.isPresent()) {
            throw new EmailAlreadyExistsException();
        }

        BusinessEmail bEmail = new BusinessEmail(null, input.email, false);

        this.businessEmailRepository.save(bEmail);
        return null;
    }

}
