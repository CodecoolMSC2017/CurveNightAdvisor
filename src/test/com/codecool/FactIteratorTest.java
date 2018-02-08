package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class FactIteratorTest {
    FactIterator f;
    Fact fact;
    Fact fact2;
    @BeforeEach
    void setUp() {
        fact = new Fact("Rózsika a pék");
        fact.setFactValueById("money",true);
        fact2 = new Fact("Csöves Gizi a hajléktalan");
        fact2.setFactValueById("money",false);
        Map<String,Fact> facts = new HashMap<String,Fact>(){
            {
                put("pék",fact);
                put("csöves",fact2);
            }
        };
        f = new FactIterator(facts);
    }

    @Test
    void hasNext() {
        assertEquals(true,f.hasNext());
        f.next();
        f.next();
        assertEquals(false,f.hasNext());
    }

    @Test
    void next() {
        Fact temp = f.next();
        assertEquals(fact,temp);
        Fact temp2 = f.next();
        assertEquals(fact2,temp2);
        assertThrows(ArrayIndexOutOfBoundsException.class,()->{
            f.next();

        });
    }
}