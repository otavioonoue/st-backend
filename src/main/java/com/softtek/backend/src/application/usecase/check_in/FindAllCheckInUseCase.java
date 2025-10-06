package com.softtek.backend.src.application.usecase.check_in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.FindAllCheckInDto;
import com.softtek.backend.src.domain.entity.CheckIn;
import com.softtek.backend.src.domain.repository.CheckInRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class FindAllCheckInUseCase implements UseCase<FindAllCheckInDto, List<CheckIn>> {

    @Autowired
    private CheckInRepository checkInRepository;

    @Override
    public List<CheckIn> execute(FindAllCheckInDto input) {
        List<CheckIn> checkIns = this.checkInRepository.findAll(input.startTime, input.endTime);

        return checkIns;
    }

}
