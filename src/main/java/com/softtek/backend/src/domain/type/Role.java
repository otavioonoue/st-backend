package com.softtek.backend.src.domain.type;

public enum Role {
    ADMIN("admin"),
    USER("user");

    private String role;

    private Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }
}
