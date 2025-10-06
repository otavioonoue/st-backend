package com.softtek.backend.shared.infrastructure.database.entity;

import java.util.Map;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.softtek.backend.src.domain.type.RiskLevel;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Document(collection = "ratings_answers")
public class SpringDataRatingAnswer {
    @Id
    private String id;

    private String userId;

    private String ratingId;

    private Map<String, String> answers;

    private int totalScore;

    private RiskLevel riskLevel;

    private double progress = 0;

    public SpringDataRatingAnswer() {}

    public SpringDataRatingAnswer(
        String id,
        String userId,
        String ratingId,
        Map<String, String> answers,
        int totalScore,
        RiskLevel riskLevel,
        double progress
    ) {
        this.id = id;
        this.userId = userId;
        this.ratingId = ratingId;
        this.answers = answers;
        this.answers = answers;
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
        this.progress = progress;
    }
}
