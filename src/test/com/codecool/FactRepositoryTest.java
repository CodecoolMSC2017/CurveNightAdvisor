package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FactRepositoryTest {
    FactRepository testFactRepo = new FactRepository();
    Fact factTwo;

    @BeforeEach
    void setUp() {
        Fact factOne = new Fact("Zámbó Árpi koncert");
        factOne.setFactValueById("money",false);
        factOne.setFactValueById("intelligence",false);
        factOne.setFactValueById("drink",true);
        testFactRepo.addFact("zArpi",factOne);

        factTwo = new Fact("Caesars Palace,Las Vegas, NV");
        factTwo.setFactValueById("money",true);
        factTwo.setFactValueById("intelligence",true);
        factTwo.setFactValueById("drink",true);

    }

    @Test
    void getIterator() {
        Fact temp = testFactRepo.getIterator().next();
        assertEquals(false, temp.getValueById("money"));
        assertEquals(true, temp.getValueById("drink"));
        assertThrows(NullPointerException.class, ()->{
            temp.getValueById("ÁrpiLover");
        });

    }

    @Test
    void addFact() {
        assertEquals(1,testFactRepo.factMap.size());
        testFactRepo.addFact("LasVegas",factTwo);
        assertEquals(2,testFactRepo.factMap.size());

    }
}