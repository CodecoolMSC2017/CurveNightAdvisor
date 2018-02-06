package com.codecool;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Answer {
    Map<Boolean, Value> values;

    public Answer(){
        this.values = new HashMap<Boolean, Value>();
    }

    public boolean evaluateAnswerByInput(String input) {
        for(Map.Entry<Boolean, Value> entry : values.entrySet()) {
            if (Arrays.asList(entry.getValue().getInputPattern()).contains(input)) {
                return true;
            }
        }
        return false;
    }


        public void addValue(Value value) {
            if(value.getBool()){
                values.put(true, value);
            }else {
                values.put(false, value);
            }
    }
}
