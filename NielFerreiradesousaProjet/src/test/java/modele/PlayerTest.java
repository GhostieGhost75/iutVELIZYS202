package modele;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void deplacement() {
        Pair[] resultat = {new Pair<Integer,Integer>(3,0),new Pair<Integer,Integer>(0,3),new Pair<Integer,Integer>(-3,0),new Pair<Integer,Integer>(0,-3),new Pair<Integer,Integer>(3,3),new Pair<Integer,Integer>(-3,-3),new Pair<Integer,Integer>(3,-3),new Pair<Integer,Integer>(-3,3)}; // Les résultats attendus
        Player joueurtest = new Player();
        for (int i = 0; i < resultat.length; i++) {
            boolean b=(joueurtest.deplacement(resultat[i]))==joueurtest.getPlayerPos();
            assertTrue(b);

    }

    @Test
    void permutation() {
    }
}