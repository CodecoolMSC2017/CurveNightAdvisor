package com.codecool;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Fact {

    private String description;
    private Map<String,Boolean> evals;

    Fact(String description) {
        this.description = description;
        this.evals = new HashMap<String, Boolean>();
    }

    public void setFactValueById(String id, boolean value) {
        evals.put(id, value);
    }

    public Set<String> getIdSet() {
        return evals.keySet();
    }

    public boolean getValueById(String input) {
        return evals.get(input);
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Boolean> getEvals() {
        return evals;
    }
}
