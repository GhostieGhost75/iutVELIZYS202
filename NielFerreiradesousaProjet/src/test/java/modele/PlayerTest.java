package modele;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    @Test
    void Player(){
        int numcristal=0;
        int NbPas=0;
        Player joueurTest = new Player();
        boolean equals = joueurTest.equals(new Position(12,12));
        boolean equals2 = joueurTest.getCristalCol()==numcristal;
        boolean equals3 = joueurTest.getNombreDePas()==NbPas;
        assertTrue(equals);
        assertTrue(equals2);
        assertTrue(equals3);

    }

    @Test
    void deplacement() {
        Position[] resultat = {new Position(12,12),new Position(12,15),new Position(9,12),new Position(12,9),new Position(15,15),new Position(9,9),new Position(15,9),new Position(9,15)}; // Les résultats attendus
        Player joueurtest = new Player();
        for (Position position : resultat) {
            boolean b = (joueurtest.deplacement(position)).equals(joueurtest);
            assertTrue(b);
        }
    }

    @Test
    void permutation() {
    Temple templeTest = new Temple(new Position(1,1),2,3);
    TreeMap<Position, Temple>templeTestTreeMap = new TreeMap<Position, Temple>();
    templeTestTreeMap.put(templeTest.getPos(),templeTest);
    Player joueurTest = new Player(1,1,1,0);
    joueurTest.setTemples(templeTestTreeMap);
    int cristalTemple = templeTest.getCristal();
    int cristalJoueur = joueurTest.getCristalCol();
    joueurTest.permutation();

    boolean permuT = templeTest.getCristal()==cristalJoueur;
    boolean permuP = joueurTest.getCristalCol()==cristalTemple;
    assertTrue(permuT);
    assertTrue(permuP);


    }

}