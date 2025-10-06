package com.softtek.backend.src.domain.entity;

import java.time.LocalDateTime;

public class CheckIn {
    private String id;

    private String userId;

    private String feelingId;

    private LocalDateTime checkInAt;

    public CheckIn() {}

    public CheckIn(String id, String userId, String feelingId, LocalDateTime checkInAt) {
        this.id = id;
        this.userId = userId;
        this.feelingId = feelingId;
        this.checkInAt = checkInAt;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFeelingId() {
        return feelingId;
    }

    public void setFeelingId(String feelingId) {
        this.feelingId = feelingId;
    }

    public LocalDateTime getCheckInAt() {
        return checkInAt;
    }

    public void setCheckInAt(LocalDateTime checkInAt) {
        this.checkInAt = checkInAt;
    }
}
