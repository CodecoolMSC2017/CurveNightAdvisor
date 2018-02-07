package com.codecool;

import java.util.Iterator;
import java.util.Map;

public class QuestionIterator implements Iterator {
    Map<String,Question> questions ;
    int idx;
    int size;
    public QuestionIterator(Map<String,Question> questions){
        this.questions = questions;
        size  = questions.size();
        idx = 0;
    }
    public boolean hasNext() {

        return idx < size;
    }

    public Question next() {
        Question[] value =  questions.values().toArray(new Question[size]);

        Question temp =value[idx];
        idx++;
        return temp;
    }
    public void remove(){
    }

}