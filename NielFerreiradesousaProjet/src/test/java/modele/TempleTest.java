package modele;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TempleTest {
    @Test
    void Temple() {
        int numTemple=5;
        int numCristal=2;
        Pair positionTemple = new Pair<Integer,Integer>(5,5);
        Temple templeTest= new Temple(new Pair<Integer,Integer>(5,5),2,5);
        boolean test1 = templeTest.getPos().equals(positionTemple);
        boolean test2 = templeTest.getCristal()==numCristal;
        boolean test3 = templeTest.getNum()==numTemple;
        assertTrue(test1);
        assertTrue(test2);
        assertTrue(test3);
    }

}