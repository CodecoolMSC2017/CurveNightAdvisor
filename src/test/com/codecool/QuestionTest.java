package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {
    Answer answer;
    Question question;

    @BeforeEach
    void setUp() {
        Value singleValue = new SingleValue("nope",false);
        List<String> values = new ArrayList<String>();
        values.add("yes");
        values.add("yep");
        values.add("jawohl");
        Value multipleValue = new MultipleValue(values,true);
        answer = new Answer();
        answer.addValue(singleValue);
        answer.addValue(multipleValue);
        question = new Question("high","Are you high?",answer);

    }

    @Test
    void getId() {
        assertEquals("high",question.getId());
    }

    @Test
    void getQuestion() {
        assertEquals("Are you high?",question.getQuestion());
    }

    @Test
    void getAnswer() {
        assertEquals(answer,question.getAnswer());
    }

    @Test
    void getEvaluatedAnswer() {
        assertEquals(true,question.getEvaluatedAnswer("yep"));
        assertEquals(false,question.getEvaluatedAnswer("nope"));
        assertThrows(NoSuchElementException.class, () -> {
            question.getEvaluatedAnswer("Siebentausendzweihundertvierundfünfzig");
        });
    }
}