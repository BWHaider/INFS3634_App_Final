package com.example.haider.infs2608learningapp;

public class QuestionModel {

    //declarations of Question and Answer strings for use in the main activity
    private String Questions;
    private String Answers;



    public QuestionModel(String questions, String answers) {
        Questions = questions;
        Answers = answers;
    }

    //getters and setters for use in the main activity
    public String getQuestions() {
        return Questions;
    }

    public void setQuestions(String questions) {
        Questions = questions;
    }

    public String getAnswers() {
        return Answers;
    }

    public void setAnswers(String answers) {
        Answers = answers;
    }



}
