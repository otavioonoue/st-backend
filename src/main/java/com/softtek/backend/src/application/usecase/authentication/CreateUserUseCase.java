package com.softtek.backend.src.application.usecase.authentication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.application.exception.EmailAlreadyUsedException;
import com.softtek.backend.src.application.exception.EmailDoesntExistsException;
import com.softtek.backend.src.application.mapper.ApplicationMapper;
import com.softtek.backend.src.application.service.EmailSender;
import com.softtek.backend.src.domain.entity.User;
import com.softtek.backend.src.domain.repository.BusinessEmailRepository;
import com.softtek.backend.src.domain.repository.UserRepository;
import com.softtek.backend.src.domain.usecase.UseCase;
import com.softtek.backend.src.infrastructure.security.TokenService;
import com.softtek.backend.src.presentation.dto.CreateUserDto;

@Service
public class CreateUserUseCase implements UseCase<CreateUserDto, Void> {

    @Autowired
    private UserRepository userRepository;

	@Autowired
	private BusinessEmailRepository businessEmailRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
	@Autowired
	private EmailSender emailSender;

	@Autowired
	private TokenService tokenService;

	@Override
	public Void execute(CreateUserDto input) {
	    User user = ApplicationMapper.toDomain(input);

		var email = this.businessEmailRepository.findByEmail(input.businessEmail);

		if (email.isEmpty()) {
			throw new EmailDoesntExistsException();
		}

		if (email.get().getIsUsed()) {
			throw new EmailAlreadyUsedException();
		}
		
		user.setPassword(passwordEncoder.encode(user.getPassword()));			
		user = this.userRepository.save(user);

		var token = this.tokenService.generateRegisterToken(user);
		this.emailSender.sendToken(input.businessEmail, token);

		return null;
	}
}