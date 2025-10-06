package com.softtek.backend.src.domain.entity;

import java.util.Map;

import com.softtek.backend.src.domain.type.RiskLevel;

public class RatingAnswer {
    private String id;

    private String userId;

    private String ratingId;

    private Map<String, String> answers;

    private int totalScore;

    private RiskLevel riskLevel;

    private double progress = 0;

    public RatingAnswer(
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
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
        this.progress = progress;
    }

    public void updateFromCalculation(Map<String, String> answers, int totalScore, RiskLevel riskLevel, double progress) {
        this.answers = answers;
        this.totalScore = totalScore;
        this.riskLevel = riskLevel;
        this.progress = progress;
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

    public String getRatingId() {
        return ratingId;
    }

    public void setRating(String ratingId) {
        this.ratingId = ratingId;
    }

    public Map<String, String> getAnswers() {
        return answers;
    }

    public void setAnswers(Map<String, String> answers) {
        this.answers = answers;
    }

    public int getTotalScore() {
        return totalScore;
    }

    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public RiskLevel getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(RiskLevel riskLevel) {
        this.riskLevel = riskLevel;
    }

    public double getProgress() {
        return progress;
    }

    public void setProgress(double progress) {
        this.progress = progress;
    }
}
