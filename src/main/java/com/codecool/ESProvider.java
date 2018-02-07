package com.codecool;

import java.util.*;

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
        collectAnswers();
        FactIterator f = factParser.factRepository.getIterator();
        while(f.hasNext()) {
            int counter = 0;
            Fact fact = f.next();
            List<String> keys = new ArrayList<String>(fact.getIdSet()) ;
            for(String str:keys){
                Boolean bool = fact.getValueById(str);
                if(inputMap.get(str) == bool) {
                    counter ++;
                }
            }
            if(counter == keys.size()) {
                return fact.getDescription();
            }

        }
        return null;
    }

}
