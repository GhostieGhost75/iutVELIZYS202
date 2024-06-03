package modele;

import java.util.TreeMap;

import static java.lang.Thread.sleep;

public class Player extends Position {
    private int cristalCol;
    private TreeMap<Position, Temple> templeMap;

    public Player() {
        super(15,15);
        cristalCol = 0;
        templeMap = new TreeMap<Position, Temple>();

    }

    public Player(int parAbs, int parOrd, int parCris, int parPas) {
        super(parAbs, parOrd);
        cristalCol = parCris;
        templeMap = new TreeMap<Position, Temple>();
    }

    public Position deplacement(Position posVoulue)  {
        while (!this.equals(posVoulue))
            this.deplacementUneCase(posVoulue);
        return new Position(abscisse, ordonnee);
    }

    public void permutation() {
        Position positionjoueur = new Position(abscisse,ordonnee);
        if (this.getTemples().containsKey(positionjoueur)){
            int templeCris = templeMap.get(positionjoueur).getCristal();
            templeMap.get(new Position(abscisse, ordonnee)).setCristal(cristalCol);
            cristalCol = templeCris;
            ;}
    }
    public void reset(){
        this.abscisse=15;
        this.ordonnee=15;
        setNombreDePas(0);
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

}
