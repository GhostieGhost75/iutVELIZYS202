package modele;

import org.javatuples.Pair;

public class Player {
    private Pair<Integer, Integer> playerPos;
    private int cristalCol;
    private int nbPas;

    public Player() {
        playerPos = new Pair (0,0);
        cristalCol = 0;
        nbPas = 0;
    }

    public Player(Pair<Integer, Integer> parPos, int parCris, int parPas) {
        playerPos = parPos;
        cristalCol = parCris;
        nbPas = parPas;
    }

    public Pair<Integer,Integer> deplacement(Pair<Integer, Integer> posVoulue) {
    }

    public void permutation(Temple parTemple) {
    }

    public Pair<Integer, Integer> getPlayerPos() {
        return playerPos;
    }
}
