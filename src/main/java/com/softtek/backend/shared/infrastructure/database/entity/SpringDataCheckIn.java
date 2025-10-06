package com.softtek.backend.shared.infrastructure.database.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "check_in")
public class SpringDataCheckIn {
    @Id
    private String id;

    private String userId;

    private String feelingId;

    private LocalDateTime checkInAt;

    public SpringDataCheckIn() {}

    public SpringDataCheckIn(String id, String userId, String feelingId, LocalDateTime checkInAt) {
        this.id = id;
        this.userId = userId;
        this.feelingId = feelingId;
        this.checkInAt = checkInAt;
    }
}
