package com.softtek.backend.shared.infrastructure.database.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "feelings")
public class SpringDataFeeling {
    @Id
    private String id;

    private String name;

    public SpringDataFeeling() {}

    public SpringDataFeeling(String id, String name) {
        this.id = id;
        this.name = name;
    }
}
