package com.softtek.backend.src.application.usecase.check_in;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.FindAllCheckInDto;
import com.softtek.backend.src.domain.entity.CheckIn;
import com.softtek.backend.src.domain.repository.CheckInRepository;
import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.CustomUserDetails;

@Service
public class FindAllCheckInUserUseCase implements UseCase<FindAllCheckInDto, List<CheckIn>> {

    @Autowired
    private CheckInRepository checkInRepository;

    @Override
    public List<CheckIn> execute(FindAllCheckInDto input) {
        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        String userId = userDetails.getUser().getId();

        List<CheckIn> checkIns = this.checkInRepository.findAllCheckInByUserId(userId, input.startTime, input.endTime);

        return checkIns;
    }

}
