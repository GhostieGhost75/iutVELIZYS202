package modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    @Test
    void Player(){
        int numcristal=0;
        int NbPas=0;
        Player joueurTest = new Player();
        boolean equals = joueurTest.getPlayerPos().equals(new Position(13,13));
        boolean equals2 = joueurTest.getCristalCol()==numcristal;
        boolean equals3 = joueurTest.getNbPas()==NbPas;
        assertTrue(equals);
        assertTrue(equals2);
        assertTrue(equals3);

    }

    @Test
    void deplacement() {
        Position[] resultat = {new Position(3,0),new Position(0,3),new Position(-3,0),new Position(0,-3),new Position(3,3),new Position(-3,-3),new Position(3,-3),new Position(-3,3)}; // Les résultats attendus
        Player joueurtest = new Player();
        for (int i = 0; i < resultat.length; i++) {
            boolean b=(joueurtest.deplacement(resultat[i])).equals(joueurtest.getPlayerPos());
            assertTrue(b);
    }
    }

    @Test
    void permutation() {
    Temple templeTest = new Temple(new Position(1,1),2,3);
    Player joueurTest = new Player(new Position(1,1),1,0);
    int cristalTemple = templeTest.getCristal();
    int cristalJoueur = joueurTest.getCristalCol();
    joueurTest.permutation(templeTest);
    boolean permuT = templeTest.getCristal()==cristalJoueur;
    boolean permuP = joueurTest.getCristalCol()==cristalTemple;
    assertTrue(permuT);
    assertTrue(permuP);


    }

}