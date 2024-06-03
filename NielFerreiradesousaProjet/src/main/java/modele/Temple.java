package modele;

import modele.Position;

public class Temple {
    private Position templePos;
    private int cristalCol;
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