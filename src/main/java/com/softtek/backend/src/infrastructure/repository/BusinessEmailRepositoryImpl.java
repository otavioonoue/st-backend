package com.softtek.backend.src.infrastructure.repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.softtek.backend.shared.infrastructure.database.repository.SpringDataBusinessEmailRepository;
import com.softtek.backend.src.domain.entity.BusinessEmail;
import com.softtek.backend.src.domain.repository.BusinessEmailRepository;
import com.softtek.backend.src.infrastructure.exception.DuplicatedKeyException;
import com.softtek.backend.src.infrastructure.mapper.InfrastructureMapper;

@Repository
public class BusinessEmailRepositoryImpl implements BusinessEmailRepository {

    private SpringDataBusinessEmailRepository repository;

    public BusinessEmailRepositoryImpl(SpringDataBusinessEmailRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<BusinessEmail> findAll() {
        return this.repository.findAll().stream()
            .map(InfrastructureMapper::toDomain)
            .collect(Collectors.toList());
    }

    @Override
    public BusinessEmail save(BusinessEmail email) {
        try {
            var business_email_data = InfrastructureMapper.toData(email);
            return InfrastructureMapper.toDomain(this.repository.save(business_email_data));
        } catch (Exception e) {
            throw new DuplicatedKeyException("Duplicated email", e);
        }

    }

    @Override
    public void delete(BusinessEmail email) {
        this.repository.delete(InfrastructureMapper.toData(email));
    }

    @Override
    public Optional<BusinessEmail> findByEmail(String email) {
        return this.repository.findByEmail(email)
            .map(InfrastructureMapper::toDomain);
    }

}
