package com.codecool;

import java.util.Map;

public class RuleParser {
    RuleRepository repository;

    public RuleParser(){
        repository = new RuleRepository();
    }


    public RuleRepository getRuleRepository(){
         return repository;
    }



}

