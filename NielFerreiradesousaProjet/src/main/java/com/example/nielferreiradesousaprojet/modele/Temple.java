package com.example.nielferreiradesousaprojet.modele;

/** Classe représentant un temple ayant une couleur, un cristal et une position */
public class Temple {

    /** objet Position : designe la position ou ce trouve le temple*/
    private Position templePos;

    /** objet int : la couleur du cristal*/
    private int cristalCol;
    /** objet int : la couleur du temple*/
    private final int templeNum;

    /**
     * Constructeur de l'objet temple en fonction des paramètres
     * @param parPos objet Position : la position du temple
     * @param parNum objet int : la couleur du temple
     * @param parCris objet int : la couleur du cristal
     */
    public Temple(Position parPos, int parNum, int parCris) {
        templePos = parPos;
        cristalCol = parCris;
        templeNum = parNum;
    }

    /**
     * permet de changer la couleur du cristal
     * @param parCris objet int : la couleur voulue
     */
    public void setCristal(int parCris) {
        cristalCol = parCris;
    }

    /**
     * permet de récupérer la couleur du cristal
     * @return objet int : la couleur du cristal
     */
    public int getCristal() {
        return cristalCol;
    }

    /**
     * permet de récupérer la couleur du temple
     * @return objet int : la couleur du temple
     */
    public int getNum() {
        return templeNum;
    }

    /**
     * permet de récupérer la position du temple
     * @return objet Position : la position du temple
     */
    public Position getPos() {
        return templePos;
    }

    /**
     * renvoie une représentation du temple en chaîne de caractères
     * @return objet String : la représentation du temple
     */
    public String toString() {return templePos.toString() + "\n couleur : "+ templeNum + " cristal : " + cristalCol;}
}