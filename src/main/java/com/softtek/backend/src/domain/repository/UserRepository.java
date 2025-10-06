package com.softtek.backend.src.domain.repository;

import java.util.List;
import java.util.Optional;

import com.softtek.backend.src.domain.entity.User;

public interface UserRepository {
    List<User> findAll();
    User save(User user);
    Optional<User> findByUsername(String username);
}