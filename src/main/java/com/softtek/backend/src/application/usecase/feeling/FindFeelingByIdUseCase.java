package com.softtek.backend.src.application.usecase.feeling;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.exception.FeelingDoesntExistsException;
import com.softtek.backend.src.domain.entity.Feeling;
import com.softtek.backend.src.domain.repository.FeelingRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class FindFeelingByIdUseCase implements UseCase<String, Optional<Feeling>> {

    @Autowired
    private FeelingRepository feelingRepository;

    @Override
    public Optional<Feeling> execute(String input) {
        var existingFeeling = this.feelingRepository.findById(input);

        if (existingFeeling.isEmpty()) {
            throw new FeelingDoesntExistsException();
        }

        return existingFeeling;
    }

}
