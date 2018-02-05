package com.codecool;

public class Question {
    String id;
    String question;
    Answer answer;

    Question(String id, String question, Answer answer){
        this.id = id;
        this.question = question;
        this.answer = answer;
    }
    String getId(){
        return id;
    }
    String getQuestion(){
        return question;
    }
    Answer getAnswer(){
        return answer;
    }
    boolean getEvaluatedAnswer(){
        return true;
    }
}
