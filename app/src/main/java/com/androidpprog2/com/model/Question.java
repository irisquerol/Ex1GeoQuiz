package com.androidpprog2.com.model;

public class Question {
    private String question;
    private boolean correct;

    //textview.id
    public Question(String question, boolean correct) {
        this.question = question;
        this.correct = correct;
    }

    public boolean checkAnswer(boolean answer) {
        return this.correct == answer;
    }

    public String getQuestion() {
        return question;
    }

    public boolean isCorrect() {
        return correct;
    }
}
