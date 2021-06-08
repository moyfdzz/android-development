package com.example.tarea_4_a01197049;

import androidx.lifecycle.ViewModel;

public class ScoreViewModel extends ViewModel {
    public int getScoreTeamA() {
        return scoreTeamA;
    }

    public void setScoreTeamA(int scoreTeamA) {
        this.scoreTeamA = scoreTeamA;
    }

    public int getScoreTeamB() {
        return scoreTeamB;
    }

    public void setScoreTeamB(int scoreTeamB) {
        this.scoreTeamB = scoreTeamB;
    }

    private int scoreTeamA = 0;
    private int scoreTeamB = 0;

    public void addScoreTeamA(int points) {
        setScoreTeamA(getScoreTeamA() + points);
    }

    public void addScoreTeamB(int points) {
        setScoreTeamB(getScoreTeamB() + points);
    }

    public void resetScores(){
        setScoreTeamA(0);
        setScoreTeamB(0);
    }
}
