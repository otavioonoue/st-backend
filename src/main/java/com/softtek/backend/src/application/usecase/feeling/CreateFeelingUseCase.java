package com.softtek.backend.src.application.usecase.feeling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.CreateFeelingDto;
import com.softtek.backend.src.application.mapper.ApplicationMapper;
import com.softtek.backend.src.domain.repository.FeelingRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class CreateFeelingUseCase implements UseCase<CreateFeelingDto, Void> {

    @Autowired
    private FeelingRepository feelingRepository;

    @Override
    public Void execute(CreateFeelingDto input) {
        var feeling = ApplicationMapper.toDomain(input);
        this.feelingRepository.save(feeling);
        
        return null;
    }

}
