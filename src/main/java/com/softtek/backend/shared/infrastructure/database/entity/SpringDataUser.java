package com.softtek.backend.shared.infrastructure.database.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.softtek.backend.src.domain.type.Role;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "users")
public class SpringDataUser {
    @Id
    private String id;
    
    @Indexed(unique = true)
    private String username;
    
    private String password;
    
    private Role role = Role.USER;

    private boolean active = false;
    
    public SpringDataUser() {}
    
    public SpringDataUser(String id, String username, String password, Role role, boolean active) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.active = active;
    }
}