package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RuleRepositoryTest {
    RuleRepository ruleRepTest = new RuleRepository();
    Answer answer;
    Question q;

    @BeforeEach
    void setUp() {
        Value singleValue = new SingleValue("no",false);
        java.util.List<String> values = new ArrayList<String>();
        values.add("igen");
        values.add("ya");
        values.add("yes");
        Value multipleValue = new MultipleValue(values,true);
        answer = new Answer();
        answer.addValue(singleValue);
        answer.addValue(multipleValue);
        q = new Question("bolt","kér kenyeret?",answer);
    }

    @Test
    void addQuestion() {
        assertEquals(0, ruleRepTest.questionMap.size());
        ruleRepTest.addQuestion(q);
        assertEquals(1, ruleRepTest.questionMap.size());

    }

    @Test
    void getIterator() {
        ruleRepTest.addQuestion(q);
        Question questionTest = ruleRepTest.getIterator().next();
        assertEquals(true, questionTest.getEvaluatedAnswer("yes"));
        assertThrows(NoSuchElementException.class, ()-> {
            questionTest.getEvaluatedAnswer("si");
        });

    }
}