package modele;

import java.util.TreeMap;

public class Player {
    private Position playerPos;
    private int cristalCol;
    private TreeMap<Position, Temple> templeMap;

    public Player() {
        playerPos = new Position(0,0);
        cristalCol = 0;
        templeMap = new TreeMap<Position, Temple>();

    }

    public Player(Position parPos, int parCris, int parPas) {
        playerPos = parPos;
        cristalCol = parCris;
        templeMap = new TreeMap<Position, Temple>();
    }

    public Position deplacement(Position posVoulue) {
        return new Position(0,0);
    }

    public void permutation() {
    }

    public Position getPlayerPos() {
        return playerPos;
    }

    public int getCristalCol() {
        return cristalCol;
    }

    public void setTemples(TreeMap<Position, Temple> temples) {
        templeMap = temples;
    }

    public int getNbPas() {
        return playerPos.getNombreDePas();
    }
}