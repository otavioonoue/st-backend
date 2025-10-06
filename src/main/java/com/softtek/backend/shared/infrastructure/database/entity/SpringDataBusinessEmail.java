package com.softtek.backend.shared.infrastructure.database.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "business_email")
public class SpringDataBusinessEmail {
    @Id
    private String id;

    @Indexed(unique = true)
    private String email;

    private boolean isUsed = false;

    public SpringDataBusinessEmail() {}

    public SpringDataBusinessEmail(String id, String email, boolean isUsed) {
        this.id = id;
        this.email = email;
        this.isUsed = isUsed;
    }
}
