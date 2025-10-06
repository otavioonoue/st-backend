package com.softtek.backend.src.domain.entity;

public class BusinessEmail {
    private String id;

    private String email;

    private boolean isUsed = false;

    public BusinessEmail(String id, String email, boolean isUsed) {
        this.id = id;
        this.email = email;
        this.isUsed = isUsed;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean getIsUsed() {
        return this.isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
