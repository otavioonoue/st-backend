package com.softtek.backend.src.application.usecase.feeling;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.entity.Feeling;
import com.softtek.backend.src.domain.repository.FeelingRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class FindAllFeelingUseCase implements UseCase<Void, List<Feeling>> {

    @Autowired
    private FeelingRepository feelingRepository;

    @Override
    public List<Feeling> execute(Void input) {
        return this.feelingRepository.findAll();
    }

}
