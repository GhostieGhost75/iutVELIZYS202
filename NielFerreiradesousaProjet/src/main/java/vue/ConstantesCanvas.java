package vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;

public interface ConstantesCanvas {
    Rectangle2D screenSize = Screen.getPrimary().getBounds();
    double LARGEUR_CANVAS = screenSize.getWidth()/2.5;
    double HAUTEUR_CANVAS = screenSize.getWidth()/2.5;
    int NB_CARRÉS_PAR_LIGNE = 25;
    double CARRE = Math.min(LARGEUR_CANVAS, HAUTEUR_CANVAS) / NB_CARRÉS_PAR_LIGNE;

    Paint COULEUR_CANVAS = Paint.valueOf("black");
}
