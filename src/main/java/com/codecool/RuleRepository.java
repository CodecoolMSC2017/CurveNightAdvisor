package com.codecool;

import java.util.HashMap;
import java.util.Map;

public class RuleRepository {
    Map<String, Question> questionMap;

    public RuleRepository() {
        questionMap = new HashMap<String, Question>();
    }


    public void addQuestion(Question question) {
        questionMap.put(question.getId(),question);
    }

    public QuestionIterator getIterator() {
        return new QuestionIterator(questionMap);
    }

}
