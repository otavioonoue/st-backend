package com.softtek.backend.shared.infrastructure.database.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.softtek.backend.src.domain.type.Question;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "ratings")
public class SpringDataRating {
    @Id
    private String id;

    private String name;

    private Map<String, Question> questions;

    private int maxScore = 0;

    public SpringDataRating() {}

    public SpringDataRating(String id, String name, Map<String, Question> questions, int maxScore) {
        this.id = id;
        this.name = name;
        this.questions = questions;
        this.maxScore = maxScore;
    }
}
