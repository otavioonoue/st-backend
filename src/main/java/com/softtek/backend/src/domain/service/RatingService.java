package com.softtek.backend.src.domain.service;

import java.util.Map;

import org.springframework.stereotype.Service;

import com.softtek.backend.src.domain.entity.Rating;
import com.softtek.backend.src.domain.type.Question;
import com.softtek.backend.src.domain.type.RiskLevel;

@Service
public class RatingService {

    public int calculateMaxScore(int questionsQuantity) {
        int maxScore = questionsQuantity * 5;
        
        return maxScore;
    }

    public int calculateScore(Rating rating, Map<String, String> answers) {
        var score = 0;
        for (Question question : rating.getQuestions().values()) {
            String key = question.getKey();
            String choice = answers.get(key);

            if (choice != null) {
                score += question.getPointsForChoice(choice);
            }
        }

        return score;
    }

    public RiskLevel calculateRisk(int score, int questionsQuantity) {
        if (questionsQuantity == 0) {
            return RiskLevel.NEUTRO;
        }

        int maxScore = questionsQuantity * 5;
        double percentage = (double) score / maxScore * 100;

        if (percentage <= 25) {
            return RiskLevel.NEUTRO;
        } else if (percentage <= 50) {
            return RiskLevel.LEVE;
        } else if (percentage <= 75) {
            return RiskLevel.MODERADO;
        } else {
            return RiskLevel.AGUDO;
        }
    }
    
    public double calculateProgressPercentage(Rating rating, Map<String, String> answers) {
        int totalQuestions = rating.getQuestions().size();
        if (totalQuestions == 0) return 0.0;

        long answeredCount = answers.entrySet().stream()
            .filter(e -> rating.getQuestions().containsKey(e.getKey()))
            .count();

        double percentage = (double) answeredCount / totalQuestions * 100;
        return Math.round(percentage * 10.0) / 10.0;
    }
}
