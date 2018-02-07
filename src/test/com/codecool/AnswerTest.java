package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {
    Answer testAnswer = new Answer();

    @BeforeEach
    void setUp() {

        List<String> food = new ArrayList<String>();
        food.add("pancake");
        food.add("maple syrup");
        food.add("strawberry");
        testAnswer.addValue(new MultipleValue(food, false));


    }

    @Test
    void evaluateAnswerByInput() {
        assertEquals(false, testAnswer.evaluateAnswerByInput("strawberry"));
        assertEquals(false, testAnswer.evaluateAnswerByInput("maple syrup"));
        assertThrows(NoSuchElementException.class, () -> {
            testAnswer.evaluateAnswerByInput("hülyeség");
        });
    }

    @Test
    void addValue() {
        assertEquals(1, testAnswer.values.size());
        testAnswer.addValue(new SingleValue("yep", true));
        assertEquals(2, testAnswer.values.size());
    }
}