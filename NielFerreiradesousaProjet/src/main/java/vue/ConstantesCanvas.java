package vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;

public interface ConstantesCanvas {
    Rectangle2D screenSize = Screen.getPrimary().getBounds();
    double LARGEUR_CANVAS = 672;
    double HAUTEUR_CANVAS = 672;
    int NB_CARRES_PAR_LIGNE = 31;
    double CARRE =Math.floor(LARGEUR_CANVAS / NB_CARRES_PAR_LIGNE);

    Paint[] COULEUR_TEMPLES ={Paint.valueOf("white"),Paint.valueOf("green"),Paint.valueOf("brown"),Paint.valueOf("GOLD"),Paint.valueOf("LIGHTSTEELBLUE"),Paint.valueOf("yellow"),Paint.valueOf("gray"),Paint.valueOf("orange"),Paint.valueOf("pink"),Paint.valueOf("cyan")};
    Paint COULEUR_JOUEUR = Paint.valueOf("red");
    Paint COULEUR_CANVAS = Paint.valueOf("black");
    Paint COULEUR_CHEMIN = Paint.valueOf("beige");
}
