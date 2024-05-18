package vue;

import javafx.geometry.Rectangle2D;
import javafx.scene.paint.Paint;
import javafx.stage.Screen;

public interface ConstantesCanvas {
    Rectangle2D screenSize = Screen.getPrimary().getBounds();
    double LARGEUR_CANVAS = 520;
    double HAUTEUR_CANVAS = 520;
    int NB_CARRES_PAR_LIGNE = 26;
    double CARRE =Math.floor(LARGEUR_CANVAS / NB_CARRES_PAR_LIGNE);

    Paint COULEUR_CANVAS = Paint.valueOf("black");
}
