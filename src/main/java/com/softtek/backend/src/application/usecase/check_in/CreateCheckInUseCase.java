package com.softtek.backend.src.application.usecase.check_in;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.dto.CreateCheckInDto;
import com.softtek.backend.src.application.exception.CheckInAlreadyCheckedException;
import com.softtek.backend.src.domain.entity.CheckIn;
import com.softtek.backend.src.domain.entity.User;
import com.softtek.backend.src.domain.repository.CheckInRepository;
import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.CustomUserDetails;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CreateCheckInUseCase implements UseCase<CreateCheckInDto, Void> {

    @Autowired
    private CheckInRepository checkInRepository;

    @Override
    public Void execute(CreateCheckInDto input) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

        User user = userDetails.getUser();

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime startOfDay = now.toLocalDate().atStartOfDay();
        LocalDateTime endOfDay = startOfDay.plusDays(1).minusNanos(1);

        var existingCheckIn = this.checkInRepository.findByUserIdAndCheckinAtBetween(user.getId(), startOfDay, endOfDay);

        if (existingCheckIn.isPresent()) {
            throw new CheckInAlreadyCheckedException();
        }

        CheckIn checkIn = new CheckIn(
            null, 
            user.getId(), 
            input.feelingId, 
            now
        );

        log.info("[INFO] New CheckIn maded by: " + user.getId());
        log.info("[INFO] Feeling: " + input.feelingId);

        this.checkInRepository.save(checkIn);

        return null;
    }

}
