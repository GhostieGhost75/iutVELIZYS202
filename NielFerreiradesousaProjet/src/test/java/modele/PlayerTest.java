package modele;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;
class PlayerTest {
    @Test
    void Player() {
        int numcristal = 0;
        int NbPas = 0;
        Player joueurTest = new Player();
        boolean equals = joueurTest.getPosPlayer().equals(new Position(15, 15));
        boolean equals2 = joueurTest.getCristalCol() == numcristal;
        boolean equals3 = joueurTest.getPosPlayer().getNombreDePas() == NbPas;
        assertTrue(equals);
        assertTrue(equals2);
        assertTrue(equals3);
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
        System.out.println(templeTest.getCristal());
        System.out.println(joueurTest.getCristalCol());
    }

    @Test
    void distancePos() {
        Position pos1 = new Position(5,5);
        Position pos2 = new Position(4,4);
        Position pos3 = new Position(7,7);
        Position pos4 = new Position(6,3);
        Position pos5 = new Position (3,6);
        assertEquals(pos1.distancePos(pos1), 0);
        assertEquals(pos1.distancePos(pos2), 2);
        assertEquals(pos1.distancePos(pos3), 4);
        assertEquals(pos1.distancePos(pos4), 3);
        assertEquals(pos1.distancePos(pos5), 3);
    }

}