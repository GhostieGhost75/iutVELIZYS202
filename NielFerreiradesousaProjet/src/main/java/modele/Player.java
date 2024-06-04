package modele;

import java.util.TreeMap;

import static java.lang.Thread.sleep;

/**abstraction d'un apprenti */
public class Player {
    /** objet Position : designe la position ou ce trouve l'apprenti*/
    private Position posPlayer;
    /** objet int : numéro de cristal qui permet d'avoir une couleur et as etre associé a un temple */
    private int cristalCol;
    /** objet TreeMap : map qui contient les temples associés a leur position pour le scénario choisit */
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

    /**
     * échange le numéro de crital du joueur avec le temple sur lequel il est et n'échange pas si il n'est pas sur un temple
     */
    public void permutation() {
        if (this.getTemples().containsKey(posPlayer)){
            int templeCris = templeMap.get(posPlayer).getCristal();
            templeMap.get(posPlayer).setCristal(cristalCol);
            cristalCol = templeCris;
            ;}
    }

    /**remet le joueur a la position de base et son numéro de cristal et son nombre de pas à 0*/
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
