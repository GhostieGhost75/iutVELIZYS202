package modele;

import org.javatuples.Pair;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    @Test
    void Player(){
        int numcristal=0;
        int NbPas=0;
        Player joueurTest = new Player();
        boolean equals = joueurTest.getPlayerPos().equals(new Pair<Integer,Integer>(0,0));
        boolean equals2 = joueurTest.getCristalCol()==numcristal;
        boolean equals3 = joueurTest.getNbPas()==NbPas;
        assertTrue(equals);
        assertTrue(equals2);
        assertTrue(equals3);

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
    Temple templeTest = new Temple(new Pair<Integer,Integer>(1,1),2,3);
    Player joueurTest = new Player(new Pair<Integer,Integer>(1,1),1,0);
    int cristalTemple = templeTest.getCristal();
    int cristalJoueur = joueurTest.getCristalCol();
    joueurTest.permutation(templeTest);
    boolean permuT = templeTest.getCristal()==cristalJoueur;
    boolean permuP = joueurTest.getCristalCol()==cristalTemple;
    assertTrue(permuT);
    assertTrue(permuP);


    }

}