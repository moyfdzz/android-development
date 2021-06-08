package com.example.tarea_2_a01197049;

public class Question {
    private String q;
    private boolean answer;

    public Question(String q, boolean answer) {
        this.q = q;
        this.answer = answer;
    }

    public String getQuestion() {
        return q;
    }

    public boolean getAnswer() {
        return answer;
    }
}
