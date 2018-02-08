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
        Fact green = test.getIterator().next();
        assertEquals(false, green.getValueById("money"));
        assertEquals(false, green.getValueById("gamble"));
        assertThrows(NullPointerException.class, ()-> {
            green.getValueById("baromság");
        });
    }
}