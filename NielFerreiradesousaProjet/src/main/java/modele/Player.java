package modele;

import java.util.TreeMap;

public class Player extends Position {
    private int cristalCol;
    private TreeMap<Position, Temple> templeMap;

    public Player() {
        super(12,12);
        cristalCol = 0;
        templeMap = new TreeMap<Position, Temple>();

    }

    public Player(int parAbs, int parOrd, int parCris, int parPas) {
        super(parAbs, parOrd);
        cristalCol = parCris;
        templeMap = new TreeMap<Position, Temple>();
    }

    public Position deplacement(Position posVoulue) {
        while (!this.equals(posVoulue))
            this.deplacementUneCase(posVoulue);
        return new Position(abscisse, ordonnee);
    }

    public void permutation() {
        int templeCris = templeMap.get(new Position(abscisse, ordonnee)).getCristal();
        templeMap.get(new Position(abscisse, ordonnee)).setCristal(cristalCol);
        cristalCol = templeCris;
    }


    public int getCristalCol() {
        return cristalCol;
    }

    public void setTemples(TreeMap<Position, Temple> temples) {
        templeMap = temples;
    }
}