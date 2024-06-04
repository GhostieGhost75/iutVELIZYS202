package vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;

/** Interface contenant les différentes valeurs utiles pour l'affichage des éléments de la carte */
public interface ConstantesCanvas {

    /** objet Rectangle2D : taille de l'écran */
    Rectangle2D screenSize = Screen.getPrimary().getBounds();

    /** objet double : la largeur du canvas */
    double LARGEUR_CANVAS = 672;

    /** objet double : la hauteur du canvas */
    double HAUTEUR_CANVAS = 672;

    /** objet int : le nombre de carrés par ligne */
    int NB_CARRES_PAR_LIGNE = 31;

    /** objet double :  la taille des carrés de la grille */
    double CARRE =Math.floor(LARGEUR_CANVAS / NB_CARRES_PAR_LIGNE);

    /** table d'objets Paint : liste des couleurs des temples/cristaux */
    Paint[] COULEUR_TEMPLES ={Paint.valueOf("white"),Paint.valueOf("green"),Paint.valueOf("brown"),Paint.valueOf("GOLD"),Paint.valueOf("LIGHTSTEELBLUE"),Paint.valueOf("yellow"),Paint.valueOf("gray"),Paint.valueOf("orange"),Paint.valueOf("pink"),Paint.valueOf("cyan")};

    /** objet Paint : couleur du joueur */
    Paint COULEUR_JOUEUR = Paint.valueOf("red");

    /** objet Paint : couleur de la grille */
    Paint COULEUR_CANVAS = Paint.valueOf("black");

    /** objet Paint : couleur de la prévisualisation des chemins pour les algorithmes */
    Paint COULEUR_CHEMIN = Paint.valueOf("beige");
=======
>>>>>>> graphics
}
