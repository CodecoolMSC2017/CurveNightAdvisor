package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class Question {
    String id;
    String question;
    Answer answer;
    Map<String,Boolean> answers;

    Question(String id, String question, Answer answer){
        this.id = id;
        this.question = question;
        this.answer = answer;
        answers = new HashMap<String, Boolean>();
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
    boolean getEvaluatedAnswer(String input){
        return getAnswer().evaluateAnswerByInput(input);
    }

}
