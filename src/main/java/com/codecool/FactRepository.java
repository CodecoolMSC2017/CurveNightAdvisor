package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class FactRepository {


    Map<String,Fact> factMap;

    public FactRepository() {
        this.factMap = new HashMap<String, Fact>();
    }

    public FactIterator getIterator() {
        return new FactIterator(factMap);
    }

    public void addFact(String id, Fact fact) {
        factMap.put(id,fact);
    }
}
