package com.example.nielferreiradesousaprojet.modele;

import java.util.TreeMap;

import static java.lang.Thread.sleep;

/** Classe représentant l'apprenti ordonnateur */
public class Player {

    /** objet Position : designe la position ou ce trouve l'apprenti*/
    private Position posPlayer;

    /** objet int : numéro de cristal qui permet d'avoir une couleur et as etre associé a un temple */
    private int cristalCol;

    /** objet TreeMap : map qui contient les temples associés a leur position pour le scénario choisit */
    private TreeMap<Position, Temple> templeMap;

    /** objet boolean : indique si l'apprenti bouge ou non */
    private boolean moving;

    /**
     * Constructeur de l'objet Player : l'initialise en position (15,15) avec aucun cristal et une
     * liste de temples vide
     */
    public Player() {
        posPlayer = new Position(15,15);
        cristalCol = 0;
        templeMap = new TreeMap<Position, Temple>();

    }

    /**
     * Constructeur de l'objet Player en fonction des paramètres
     * @param parAbs objet int : l'abscisse de la position
     * @param parOrd objet int : l'ordonnée de la position
     * @param parCris objet int : le cristal porté
     */
    public Player(int parAbs, int parOrd, int parCris) {
        posPlayer = new Position(parAbs,parOrd);
        cristalCol = parCris;
        templeMap = new TreeMap<Position, Temple>();
        moving = false;
    }

    /**
     * échange le numéro de cristal du joueur avec le temple sur lequel il est et n'échange pas si il n'est pas sur un temple
     */
    public void permutation() {
        if (this.getTemples().containsKey(posPlayer)){
            int templeCris = templeMap.get(posPlayer).getCristal();
            templeMap.get(posPlayer).setCristal(cristalCol);
            cristalCol = templeCris;
            ;}
    }

    /**remet le joueur à son état initial (constructeur vide) */
    public void reset(){
        this.cristalCol=0;
        posPlayer = new Position(15,15);
        posPlayer.setNombreDePas(0);
    }

    /**
     * permet de récuperer le cristal du joueur
     * @return objet int : le cristal du joueur
     */
    public int getCristalCol() {
        return cristalCol;
    }

    /**
     * permet d'indiquer le dictionnaire des temples à l'apprenti
     * @param temples objet TreeMap : le dictionnaire des temples
     */
    public void setTemples(TreeMap<Position, Temple> temples) {
        templeMap = temples;
    }

    /**
     * permet de récupérer le dictionnaire des temples
     * @return objet TreeMap : le dictionnaire des temples
     */
    public TreeMap<Position, Temple> getTemples() {
        return templeMap;
    }

    /**
     * permet de récupérer la position du joueur
     * @return objet Position : la position du joueur
     */
    public Position getPosPlayer() {return posPlayer;}

    /**
     * permet de changer l'état de l'apprenti (moving)
     * @param parBool objet boolean : si l'apprenti bouge ou pas
     */
    public void setMoving(boolean parBool) {moving = parBool;}

    /**
     * permet de récupérer l'état de l'apprenti (moving)
     * @return objet boolean : si l'apprenti bouge ou pas
     */
    public boolean getMoving() {return moving;}

}
