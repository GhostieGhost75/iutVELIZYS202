package modele;

import modele.Position;

/**abstraction d'un temple qui as un numéro ,un numéro de cristal et une position dans la map */
public class Temple {
    /** objet Position : designe la position ou ce trouve le temple*/
    private Position templePos;
    /**

     /** objet int : numéro de cristal qui permet d'avoir une couleur et as etre associé a un temple*/
    private int cristalCol;
    /** objet int : numéro de Temple qui permet d'avoir une couleur et as etre associé a un cristal*/
    private final int templeNum;

    public Temple(Position parPos, int parNum, int parCris) {
        templePos = parPos;
        cristalCol = parCris;
        templeNum = parNum;
    }

    public void setCristal(int parCris) {
        cristalCol = parCris;
    }

    public int getCristal() {
        return cristalCol;
    }

    public int getNum() {
        return templeNum;
    }

    public Position getPos() {
        return templePos;
    }

    public String toString() {return templePos.toString() + "\n couleur : "+ templeNum + " cristal : " + cristalCol;}
}