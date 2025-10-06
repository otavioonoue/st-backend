package com.softtek.backend.src.application.usecase.feeling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.exception.FeelingDoesntExistsException;
import com.softtek.backend.src.domain.repository.FeelingRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class DeleteFeelingUseCase implements UseCase<String, Void> {

    @Autowired
    private FeelingRepository feelingRepository;

    @Override
    public Void execute(String input) {
        var existingFeeling = this.feelingRepository.findById(input);

        if (existingFeeling.isEmpty()) {
            throw new FeelingDoesntExistsException();
        }

        this.feelingRepository.delete(existingFeeling.get().getId());
        
        return null;
    }

}
