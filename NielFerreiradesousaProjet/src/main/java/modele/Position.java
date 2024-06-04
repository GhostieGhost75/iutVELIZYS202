package modele;

/**correspond a des coordonnées de la carte*/
public class Position implements Comparable<Position>{
    /** objet int : indique le nombre de pas*/
    private static int nombreDePas = 0;
    /** objet int : l'abscisse de coordonée*/
    protected int abscisse;
    /** objet int : l'ordonée de coordonée*/
    protected int ordonnee;

    public Position(int parAbs, int parOrd) {
        this.abscisse = parAbs;
        this.ordonnee = parOrd;
    }

    public boolean equals(Position parPosition) {
        return (this.abscisse == parPosition.abscisse && this.ordonnee== parPosition.ordonnee);
    }

    public void deplacementUneCase(Position parPosition) {
        if (!this.equals(parPosition)) {
            nombreDePas++;
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
    public void incrementerNombreDePas() {
        nombreDePas++;
    }

    public int getAbscisse() {return abscisse;}

    public int getOrdonnee() {return ordonnee;}

    public String toString() {return "x : "+abscisse +"  y : "+ordonnee+"\n";}

    public static int getNombreDePas() {return nombreDePas;}

    public static void setNombreDePas(int nombreDePas) {
        Position.nombreDePas = nombreDePas;
    }

    @Override
    public int compareTo(Position parPosition) {
        if (this.abscisse == parPosition.abscisse) {
            return this.ordonnee-parPosition.ordonnee;
        }
        return this.abscisse - parPosition.abscisse;
    }

    public void setAbscisse(int parabscisse) {
        this.abscisse=parabscisse;
    }

    public void setOrdonnee(int parordonnee) {
        this.ordonnee = parordonnee;
    }

    /**
     * calcule la distance entre deux coordonées
     * @param parPos
     * @return
     */
    public int distancePos(Position parPos) {
        return Math.abs(this.ordonnee - parPos.ordonnee) + Math.abs(this.abscisse - parPos.abscisse);
    }
}
