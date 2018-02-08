package com.codecool;



import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {

    RuleParser ruleParserTest = new RuleParser();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getRepository() {
        RuleRepository ruleRepoTest = ruleParserTest.getRepository();
        Question narco = ruleRepoTest.getIterator().next();
        assertEquals(true, narco.getEvaluatedAnswer("crocodile"));
        assertEquals(false, narco.getEvaluatedAnswer("weed"));
        assertThrows(NoSuchElementException.class, ()-> {
            narco.getEvaluatedAnswer("baromság");
        });
    }
}
