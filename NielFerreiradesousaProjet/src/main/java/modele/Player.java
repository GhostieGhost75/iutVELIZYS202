package modele;

import java.util.ArrayList;

public class Player {
    private Position playerPos;
    private int cristalCol;
    private ArrayList<Temple> templeList;

    public Player() {
        playerPos = new Position(0,0);
        cristalCol = 0;
        templeList = new ArrayList<Temple>();

    }

    public Player(Position parPos, int parCris, int parPas) {
        playerPos = parPos;
        cristalCol = parCris;
        templeList = new ArrayList<Temple>();
    }

    public Position deplacement(Position posVoulue) {
        return new Position(0,0);
    }

    public void permutation(Temple parTemple) {
    }

    public Position getPlayerPos() {
        return playerPos;
    }

    public int getCristalCol() {
        return cristalCol;
    }

    public void setTemples(ArrayList<Temple> temples) {
        templeList = temples;
    }

    public int getNbPas() {
        return playerPos.getNombreDePas();
    }
}