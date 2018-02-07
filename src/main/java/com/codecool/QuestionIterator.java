package com.codecool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class QuestionIterator implements Iterator {
    Map<String,Question> questions ;
    int idx = 0;
    int size;
    public QuestionIterator(Map<String,Question> questions){
        this.questions = questions;
        size  = questions.size();
    }
    public boolean hasNext() {
        return idx + 1 < size;
    }

    public String next() {
        String[] keys = (String[]) questions.keySet().toArray();
        idx++;
        return keys[idx--];
    }
    public void remove(){

    }

}