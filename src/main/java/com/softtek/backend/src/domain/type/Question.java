package com.softtek.backend.src.domain.type;

import java.util.Map;

public class Question {
    private String key;
    private String text;
    private Map<String, AnswerOption> alternatives;

    public Question(String key, String text, Map<String, AnswerOption> alternatives) {
        this.key = key;
        this.text = text;
        this.alternatives = alternatives;
    }

    public int getPointsForChoice(String choice) {
        return alternatives.getOrDefault(choice, new AnswerOption("", 0)).getPoints();
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Map<String, AnswerOption> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(Map<String, AnswerOption> alternatives) {
        this.alternatives = alternatives;
    }
}
