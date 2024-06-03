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
        boolean equals = joueurTest.equals(new Position(15,15));
        boolean equals2 = joueurTest.getCristalCol()==numcristal;
        boolean equals3 = joueurTest.getPosPlayer().getNombreDePas()==NbPas;
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

}