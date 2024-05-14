package modele;

public class Position {
    private static int nombreDePas = 0;
    private int abscisse;
    private int ordonnee;

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
        return;
    }

    public int getAbscisse() {return abscisse;}

    public int getOrdonnee() {return ordonnee;}

    public String toString() {return "x : "+abscisse +"\ny : "+ordonnee;}

    public int getNombreDePas() {return nombreDePas;}
}
