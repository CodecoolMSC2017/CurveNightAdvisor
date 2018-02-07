package com.codecool;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Answer {
    Map<Boolean, Value> values;

    public Answer(){
        this.values = new HashMap<Boolean, Value>();
    }

    public boolean evaluateAnswerByInput(String input) {
        for(Map.Entry<Boolean, Value> entry : values.entrySet()) {
            for(int i = 0;i < entry.getValue().getInputPattern().size();i++){
                if(entry.getValue().getInputPattern().get(i).equals(input)){
                    return entry.getKey();
                }
            }
        }
        throw new NoSuchElementException();

    }


    public void addValue(Value value) {
        values.put(value.getSelectionType(),value);
    }
}
