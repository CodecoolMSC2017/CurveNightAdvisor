package com.codecool;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ESProvider {
    FactParser factParser;
    RuleParser ruleParser;
    Map<String, Boolean> inputMap;
    String input;

    Scanner scan  = new Scanner(System.in);

    ESProvider(FactParser factParser,RuleParser ruleParser){
        this.factParser = factParser;
        this.ruleParser = ruleParser;
        inputMap = new HashMap<String, Boolean>();

    }
    void collectAnswers(){
       QuestionIterator a = ruleParser.RuleRepository.getIterator();

       while(a.hasNext()){
            Question q = a.next();
            System.out.println(q.getQuestion());
            input = scan.nextLine();
            Boolean bool = getAnswerByQuestion(q.getId());
            inputMap.put(q.getId(),bool);


        }
    }
    boolean getAnswerByQuestion(String questionId){
        Boolean bool = false;
        Map<String,Question> temp= ruleParser.RuleRepository.questionMap;
        for(Map.Entry<String,Question> entry : temp.entrySet()){
            if (entry.getKey().equals(questionId)){
                 bool = entry.getValue().getEvaluatedAnswer(input);
            }
        }
        return bool;

    }
    String evaluate(){
        return null;
    }

}
