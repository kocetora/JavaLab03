package com.company.GradeBook;

public class Score {
    private int scoreAssistant;
    private int scoreLector;
    public Score(int scoreAssistant) {
        this.scoreAssistant = scoreAssistant;
    }

    public int getScoreAssistant() {
        return scoreAssistant;
    }
    public void setScoreAssistant(int scoreAssistant) {
        this.scoreAssistant = scoreAssistant;
    }
    public int getScoreLecturer() {
        return scoreLector;
    }
    public void setScoreLecturer(int scoreLector) {
        this.scoreLector = scoreLector;
    }
}
