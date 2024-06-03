package modele;

import org.junit.jupiter.api.Test;

import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

/** Classe de test des fonctions liées au joueur (classe Player) */
public class PlayerTest {

    /**
     * Crée un objet Player.
     * Pas d'erreur si l'objet correspond aux attentes.
     */
    @Test
    public void Player() {
        int numcristal = 0;
        int NbPas = 0;
        Player joueurTest = new Player();
        boolean equals = joueurTest.getPosPlayer().equals(new Position(15, 15));
        boolean equals2 = joueurTest.getCristalCol() == numcristal;
        boolean equals3 = Position.getNombreDePas() == NbPas;
        assertTrue(equals);
        assertTrue(equals2);
        assertTrue(equals3);
    }

    /**
     * Vérifie le bon fonctionnement de la fonction permutation.
     * Pas d'erreur si la permutation est réussie.
     */
    @Test
    public void permutation() {
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

    /**
     * Vérifie le bon fonctionnement de la fonction donnant l'écart entre deux positions.
     * Pas d'erreur si chaque distance est correcte.
     */
    @Test
    public void distancePos() {
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