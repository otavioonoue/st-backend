package com.softtek.backend.src.domain.type;

public class AnswerOption {
    private String optionText;
    private int points;

    public AnswerOption(String optionText, int points) {
        this.optionText = optionText;
        this.points = points;
    }

    public String getOptionText() {
        return optionText;
    }

    public void setOptionText(String optionText) {
        this.optionText = optionText;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
