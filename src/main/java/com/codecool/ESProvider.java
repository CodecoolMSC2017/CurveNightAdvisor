/*package com.codecool;

import java.util.Map;
import java.util.Scanner;

public class ESProvider {
    FactParser factParser;
    RuleParser ruleParser;
    Map<Question,Answer> inputMap =


    ESProvider(FactParser factParser,RuleParser ruleParser){
        this.factParser = factParser;
        this.ruleParser = ruleParser;
        Scanner scan  = new Scanner(System.in);
    }
    void collectAnswers(){
        while()
    }
    boolean getAnswerByQuestion(String questionId){
        Map<String,Question> temp= ruleParser.repository.questionMap;
        for(Map.Entry<String,Question> entry : temp.entrySet()){
            if (entry.getKey().equals(questionId)){
                return entry.getValue().getEvaluatedAnswer(answer);
            }
        }

    }
    String evaluate(){

    }

}*/
