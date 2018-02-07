package com.codecool;

import java.util.*;

public class ESProvider {
    FactParser factParser;
    RuleParser ruleParser;
    Map<String, Boolean> inputMap;
    String input;
    String[] availableNarcotics = new String[9];
    String[] availableAlcohols = new String[12];


    Scanner scan  = new Scanner(System.in);

    ESProvider(FactParser factParser,RuleParser ruleParser){
        this.factParser = factParser;
        this.ruleParser = ruleParser;
        inputMap = new HashMap<String, Boolean>();

    }
    void collectAnswers(){
       QuestionIterator a = ruleParser.RuleRepository.getIterator();
        getAvaiableValues();
       while(a.hasNext()){
            Question q = a.next();
            if(q.getId().equals("narcotics")) {
                System.out.println(q.getQuestion());
                printAvaiable(availableNarcotics);
            }
            else if (q.getId().equals("drink")){
               System.out.println(q.getQuestion());
               printAvaiable(availableAlcohols);
                }

            else{
                System.out.println(q.getQuestion());
            }
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
        int max = 0;
        String d = "";
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
            if(counter > max) {
                max = counter;
                d = fact.getDescription();

            }

        }
        return d;
    }
    void getAvaiableValues(){
        int counter = 0;
        int j = 0;
        int k = 0;
        for(String[] available : ruleParser.values){

            if (counter < 2){
                for (int i = 0; i< available.length;i++){
                    availableAlcohols[j+i] = available[i];

                }
                counter++;
                j = available.length;
            }

            else{
                for (int i = 0; i< available.length;i++){
                    availableNarcotics[k+i] = available[i];

                }
                counter++;
                k = available.length;

            }

        }

    }
    void printAvaiable(String[] tempArr){
        for (int i = 0; i < tempArr.length;i++) {
            if (i == tempArr.length - 1) {
                System.out.println(tempArr[i]);
            } else {
                System.out.print(tempArr[i] + ",");
            }
        }
    }
}
