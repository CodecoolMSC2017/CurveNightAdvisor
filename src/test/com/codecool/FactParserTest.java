package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactParserTest {

    FactParser factParserTest = new FactParser();

    @BeforeEach
    void setUp() {
    }

    @Test
    void getFactRepository() {
        FactRepository test = factParserTest.getFactRepository();
        Fact ozora = test.getIterator().next();
        assertEquals(true, ozora.getValueById("money"));
        assertEquals(false, ozora.getValueById("gamble"));
        assertThrows(NullPointerException.class, ()-> {
            ozora.getValueById("baromság");
        });
    }
}