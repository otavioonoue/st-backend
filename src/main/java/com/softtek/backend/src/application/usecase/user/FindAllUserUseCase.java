package com.softtek.backend.src.application.usecase.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.entity.User;
import com.softtek.backend.src.domain.repository.UserRepository;
import com.softtek.backend.src.domain.usecase.UseCase;

@Service
public class FindAllUserUseCase implements UseCase<Void, List<User>> {

    @Autowired
    private UserRepository userRepository;
    
	@Override
	public List<User> execute(Void input) {
		return this.userRepository.findAll();
	}
    
}