package com.codecool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FactIterator implements Iterator {

    static Map<String,Boolean> facts = new HashMap<String, Boolean>();
    String[] keys = (String[]) facts.keySet().toArray();
    int idx = 0;
    int size = facts.size();
    public boolean hasNext() {
        return idx + 1 < size;
    }

    public String next() {
        idx++;
        return keys[idx--];
    }
    public void remove(){
        
    }

}