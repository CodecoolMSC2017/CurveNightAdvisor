package com.codecool;

import java.util.*;

public class RuleRepository {
    Map<String, Question> questionMap;
    Iterator<Question> questionIterator;

    public RuleRepository() {
        questionMap = new HashMap<String, Question>();
        questionIterator = getIterator();
    }


    public void addQuestion(Question question) {
        questionMap.put(question.getId(),question);
    }

    public Iterator<Question> getIterator() {
        List<Question> questionList = new ArrayList<Question>();
        return new QuestionIterator(questionList);
    }

}
