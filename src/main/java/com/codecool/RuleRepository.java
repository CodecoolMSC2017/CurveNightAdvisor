package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class RuleRepository {
    Map<String, Question> map;
    Iterator<Question> questionIterator;

    public RuleRepository(Map<String, Question> map) {
        this.map = map;
        questionIterator = getIterator();
    }


    public void addQuestion(Question question) {
    }

    public Iterator<Question> getIterator() {
        List<Question> questionList = new ArrayList<Question>();
        return new QuestionIterator(questionList);
    }

}
