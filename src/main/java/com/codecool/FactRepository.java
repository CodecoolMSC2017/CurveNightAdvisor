package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class FactRepository {

    private FactIterator iterator;
    Map<String,Fact> factMap;

    public FactRepository() {
        this.factMap = new HashMap<String, Fact>();

    }

    public FactIterator getIterator() {
        return new FactIterator();
    }

    public void addFact(String id, Fact fact) {
        factMap.put(id,fact);
    }
}
