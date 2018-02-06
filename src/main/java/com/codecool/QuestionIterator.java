package com.codecool;

import java.util.Iterator;
import java.util.List;

public class QuestionIterator implements Iterator {

    private int i;
    private List<Question> list;

    public QuestionIterator(List<Question> list) {
        this.list = list;
    }

    public boolean hasNext() {
        if (i + 1 < list.size()) {
            return true;
        }
        return false;
    }

    public Question next() {
        return list.get(i++);
    }

    public void remove() {

    }
}