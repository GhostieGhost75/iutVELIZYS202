package modele;

import java.util.TreeMap;

import static java.lang.Thread.sleep;

public class Player {

    private Position posPlayer;
    private int cristalCol;
    private TreeMap<Position, Temple> templeMap;

    public Player() {
        posPlayer = new Position(15,15);
        cristalCol = 0;
        templeMap = new TreeMap<Position, Temple>();

    }

    public Player(int parAbs, int parOrd, int parCris, int parPas) {
        posPlayer = new Position(parAbs,parOrd);
        cristalCol = parCris;
        templeMap = new TreeMap<Position, Temple>();
    }

    public Position deplacement(Position posVoulue)  {
        while (!this.equals(posVoulue))
            posPlayer.deplacementUneCase(posVoulue);
        return new Position(posPlayer.abscisse, posPlayer.ordonnee);
    }

    public void permutation() {
        if (this.getTemples().containsKey(posPlayer)){
            int templeCris = templeMap.get(posPlayer).getCristal();
            templeMap.get(posPlayer).setCristal(cristalCol);
            cristalCol = templeCris;
            ;}
    }
    public void reset(){
        this.cristalCol=0;
        posPlayer = new Position(15,15);
        posPlayer.setNombreDePas(0);
    }

    public int getCristalCol() {
        return cristalCol;
    }

    public void setTemples(TreeMap<Position, Temple> temples) {
        templeMap = temples;
    }
    public TreeMap<Position, Temple> getTemples() {
        return templeMap;
    }

    public Position getPosPlayer() {return posPlayer;}

}
