package com.softtek.backend.src.domain.entity;

import java.util.Map;

import com.softtek.backend.src.domain.type.Question;

public class Rating {
    private String id;

    private String name;

    private Map<String, Question> questions;

    private int maxScore = 0;

    public Rating(String id, String name, Map<String, Question> questions, int maxScore) {
        this.id = id;
        this.name = name;
        this.questions = questions;
        this.maxScore = maxScore;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Map<String, Question> questions) {
        this.questions = questions;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }
}
