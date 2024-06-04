package modele;

/** Classe représentant les coordonnées sur la carte du jeu */
public class Position implements Comparable<Position>{

    /** objet int : indique le nombre de pas*/
    private static int nombreDePas = 0;

    /** objet int : l'abscisse de coordonée*/
    protected int abscisse;

    /** objet int : l'ordonée de coordonée*/
    protected int ordonnee;

    /**
     * Constructeur de l'objet Position en fonction des paramètres
     * @param parAbs objet int : l'abscisse de la position
     * @param parOrd objet int : l'ordonnée de la position
     */
    public Position(int parAbs, int parOrd) {
        this.abscisse = parAbs;
        this.ordonnee = parOrd;
    }

    /**
     * vérifie si les deux positions sont égales
     * @param parPosition objet Position : la position à comparer
     * @return objet boolean : vrai si égales, faux si non
     */
    public boolean equals(Position parPosition) {
        return (this.abscisse == parPosition.abscisse && this.ordonnee== parPosition.ordonnee);
    }

    /**
     * rapproche d'une case la position de son objectif
     * @param parPosition objet Position : l'objectif
     */
    public void deplacementUneCase(Position parPosition) {
        if (!this.equals(parPosition)) {
            if (this.abscisse > parPosition.abscisse) {
                this.abscisse -=1;
            } else if (this.abscisse < parPosition.abscisse) {
                this.abscisse += 1;
            } else if (this.ordonnee > parPosition.ordonnee) {
                this.ordonnee -=1;
            } else {
                this.ordonnee += 1;
            }
        }
    }

    /** augmente de 1 le compteur de pas */
    public void incrementerNombreDePas() {
        nombreDePas++;
    }

    /**
     * permet de récupérer l'abscisse
     * @return objet int : l'abscisse
     */
    public int getAbscisse() {return abscisse;}


    /**
     * permet de récupérer l'ordonnée
     * @return objet int : l'ordonnée
     */
    public int getOrdonnee() {return ordonnee;}

    /**
     * renvoie une représentation de la position sous forme de chaîne de caractère
     * @return objet String : la représentation de la position
     */
    public String toString() {return "x : "+abscisse +"  y : "+ordonnee+"\n";}

    /**
     * permet de récupérer le nombre de pas
     * @return objet int : le nombre de pas
     */
    public static int getNombreDePas() {return nombreDePas;}

    /**
     * remplace le nombre de pas par une valeur voulue
     * @param nombreDePas objet int : le nombre de pas voulu
     */
    public static void setNombreDePas(int nombreDePas) {
        Position.nombreDePas = nombreDePas;
    }


    /**
     * compare this à une position en paramètre
     * @param parPosition objet Position : la position à comparer
     * @return objet int : le résultat de la comparaison
     */
    @Override
    public int compareTo(Position parPosition) {
        if (this.abscisse == parPosition.abscisse) {
            return this.ordonnee-parPosition.ordonnee;
        }
        return this.abscisse - parPosition.abscisse;
    }

    /**
     * calcule la distance entre deux positions
     * @param parPos objet Position : la deuxième position
     * @return objet int : la distance entre deux positions
     */
    public int distancePos(Position parPos) {
        return Math.abs(this.ordonnee - parPos.ordonnee) + Math.abs(this.abscisse - parPos.abscisse);
    }
}
