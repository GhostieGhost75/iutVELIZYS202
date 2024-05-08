package modele;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    @Test
    void Player(){
        Player joueurTest = new Player();
        boolean equals = joueurTest.getPlayerPos().equals(new Pair<Integer,Integer>(0,0));
        boolean equals2 = joueurTest.getCristalCol()==0;
        boolean equals3 = joueurTest.getNbPas()==0;

    }

    @Test
    void deplacement() {
        Pair[] resultat = {new Pair<Integer,Integer>(3,0),new Pair<Integer,Integer>(0,3),new Pair<Integer,Integer>(-3,0),new Pair<Integer,Integer>(0,-3),new Pair<Integer,Integer>(3,3),new Pair<Integer,Integer>(-3,-3),new Pair<Integer,Integer>(3,-3),new Pair<Integer,Integer>(-3,3)}; // Les résultats attendus
        Player joueurtest = new Player();
        for (int i = 0; i < resultat.length; i++) {
            boolean b=(joueurtest.deplacement(resultat[i])).equals(joueurtest.getPlayerPos());
            assertTrue(b);
    }
    }

    @Test
    void permutation() {

        }

}