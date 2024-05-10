package vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;

public interface ConstantesCanvas {
    Rectangle2D screenSize = Screen.getPrimary().getBounds();
    final double LARGEUR_CANVAS = screenSize.getWidth()/2.5;
    final double HAUTEUR_CANVAS = screenSize.getWidth()/2.5;
    final int NB_CARRÉS_PAR_LIGNE = 25;
    final double CARRE = Math.min(LARGEUR_CANVAS, HAUTEUR_CANVAS) / NB_CARRÉS_PAR_LIGNE;

    final Paint COULEUR_CANVAS = Paint.valueOf("black");
}
