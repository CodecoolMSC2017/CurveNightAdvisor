package com.codecool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FactIterator implements Iterator {
    Map<String,Fact> facts ;
    int idx;
    int size;
    public FactIterator(Map<String,Fact> facts){
        this.facts = facts;
        size  = facts.size();
        idx = 0;
    }
    public boolean hasNext() {
        return idx < size;
    }

    public Fact next() {
        Fact[] value =  facts.values().toArray(new Fact[size]);

        Fact temp =value[idx];
        idx++;
        return temp;
    }
    public void remove(){
        
    }

}