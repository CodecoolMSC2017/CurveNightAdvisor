package com.codecool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FactIterator implements Iterator {
    Map<String,Fact> facts ;
    int idx = 0;
    int size;
    public FactIterator(Map<String,Fact> facts){
        this.facts = facts;
        size  = facts.size();
    }
    public boolean hasNext() {
        return idx + 1 < size;
    }

    public String next() {
        String[] keys = (String[]) facts.keySet().toArray();
        idx++;
        return keys[idx--];
    }
    public void remove(){
        
    }

}