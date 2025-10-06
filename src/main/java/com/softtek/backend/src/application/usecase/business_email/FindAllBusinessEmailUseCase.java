package com.softtek.backend.src.application.usecase.business_email;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.entity.BusinessEmail;
import com.softtek.backend.src.domain.repository.BusinessEmailRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class FindAllBusinessEmailUseCase implements UseCase<Void, List<BusinessEmail>> {

    @Autowired
    private BusinessEmailRepository businessEmailRepository;

    @Override
    public List<BusinessEmail> execute(Void input) {
        return this.businessEmailRepository.findAll();
    }

}
