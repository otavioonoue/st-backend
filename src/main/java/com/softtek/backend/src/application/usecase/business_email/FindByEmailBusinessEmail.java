package com.softtek.backend.src.application.usecase.business_email;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.entity.BusinessEmail;
import com.softtek.backend.src.domain.repository.BusinessEmailRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class FindByEmailBusinessEmail implements UseCase<String, Optional<BusinessEmail>> {

    @Autowired
    private BusinessEmailRepository businessEmailRepository;

    @Override
    public Optional<BusinessEmail> execute(String input) {
        return this.businessEmailRepository.findByEmail(input);
    }
}
