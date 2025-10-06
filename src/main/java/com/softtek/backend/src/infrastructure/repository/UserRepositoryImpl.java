package com.softtek.backend.src.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.softtek.backend.shared.infrastructure.database.entity.SpringDataUser;
import com.softtek.backend.shared.infrastructure.database.repository.SpringDataUserRepository;
import com.softtek.backend.src.domain.entity.User;
import com.softtek.backend.src.domain.repository.UserRepository;
import com.softtek.backend.src.infrastructure.exception.DuplicatedKeyException;
import com.softtek.backend.src.infrastructure.mapper.InfrastructureMapper;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final SpringDataUserRepository repository;
    
    public UserRepositoryImpl(SpringDataUserRepository repository) {
        this.repository = repository;
    }
    
	@Override
	public List<User> findAll() {
		return this.repository.findAll().stream()
		    .map(InfrastructureMapper::toDomain)
		    .collect(Collectors.toList());
	}

	@Override
	public User save(User user) {
		SpringDataUser dataUser = InfrastructureMapper.toData(user);
		
		try {
	        return InfrastructureMapper.toDomain(this.repository.save(dataUser));
		} catch(Exception e) {
		    throw new DuplicatedKeyException("Duplicated field", e);
		}
	}

	@Override
	public Optional<User> findByUsername(String username) {
		Optional<User> user = this.repository.findByUsername(username).map(InfrastructureMapper::toDomain);

		return user;
	}

	
}