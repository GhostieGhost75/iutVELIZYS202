package modele;

import org.javatuples.Pair;

public class Temple {
    private final Pair<Integer, Integer> templePos;
    private int cristalCol;
    private final int templeNum;

    public Temple(Pair<Integer, Integer> parPos, int parCris, int parNum) {
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

    public Pair<Integer, Integer> getPos() {
        return templePos;
    }
}
