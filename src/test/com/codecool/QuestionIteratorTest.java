package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QuestionIteratorTest {

    QuestionIterator question;
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
        Map<String ,Question> questionMap = new HashMap<String ,Question>(){{ put("bolt",q);}};
        question = new QuestionIterator(questionMap);

    }

    @Test
    void hasNext() {
        assertEquals(true, question.hasNext());
        question.next();
        assertEquals(false,question.hasNext());
    }

    @Test
    void next() {
        Question k = question.next();
        assertEquals(true,k.getEvaluatedAnswer("igen"));
        assertEquals(false,k.getEvaluatedAnswer("no"));
        assertThrows(NoSuchElementException.class,()->{
            k.getEvaluatedAnswer("jahfkj");

        });
        assertThrows(ArrayIndexOutOfBoundsException.class,()->{
           question.next();
        });
    }
}