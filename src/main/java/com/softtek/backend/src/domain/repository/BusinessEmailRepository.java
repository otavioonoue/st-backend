package com.softtek.backend.src.domain.repository;

import java.util.List;
import java.util.Optional;

import com.softtek.backend.src.domain.entity.BusinessEmail;

public interface BusinessEmailRepository {
    List<BusinessEmail> findAll();
    BusinessEmail save(BusinessEmail email);
    void delete(BusinessEmail email);
    Optional<BusinessEmail> findByEmail(String email);
}
