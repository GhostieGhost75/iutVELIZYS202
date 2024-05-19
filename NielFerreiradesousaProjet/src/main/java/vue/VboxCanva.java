package vue;

import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import modele.Player;
import modele.Position;
import modele.Temple;
import vue.ConstantesCanvas;

public class VboxCanva extends VBox implements ConstantesCanvas {
    public Canvas canvasCarte;
    public Label labelNombreDePas;
    public GraphicsContext graphicsContext2D;

    public VboxCanva() {
        labelNombreDePas = new Label("Nombre de pas : 0");
        canvasCarte = new Canvas(LARGEUR_CANVAS, HAUTEUR_CANVAS);
        graphicsContext2D = canvasCarte.getGraphicsContext2D();

        // Dessiner la grille
        dessinerGrille();

        this.getChildren().add(labelNombreDePas);
        VBox.setMargin(labelNombreDePas, new Insets(30));
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte, new Insets(30));
    }

    public void dessinerGrille() {
        graphicsContext2D.setStroke(COULEUR_CANVAS);
        for (int i = 0; i < LARGEUR_CANVAS; i += CARRE) {
            for (int j = 0; j < HAUTEUR_CANVAS; j += CARRE) {
                graphicsContext2D.strokeRect(i, j, CARRE, CARRE);
            }
        }

        // Dessiner les indices de colonnes
        int numCol = 0;
        graphicsContext2D.setFill(COULEUR_CANVAS);
        for (double i = CARRE; i < LARGEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numCol), i + CARRE / 3, CARRE / 2);
            numCol++;
        }

        // Dessiner les indices de lignes
        int numLigne = 0;
        graphicsContext2D.setFill(COULEUR_CANVAS);
        for (double i = CARRE; i < HAUTEUR_CANVAS; i += CARRE) {
            graphicsContext2D.fillText(Integer.toString(numLigne), CARRE / 3, i + CARRE / 2);
            numLigne++;
        }
    }

    public void afficherJoueur(Player player){
        Position position = player.getPlayerPos();
        double posX = (position.getAbscisse()+1) * CARRE;
        double posY = (position.getOrdonnee()+1) * CARRE;
        System.out.println("Dessiner joueur à : (" + posX + ", " + posY + ")");
        graphicsContext2D.setFill(COULEUR_JOUEUR);
        graphicsContext2D.fillOval(posX,posY,CARRE,CARRE);
    }
    public void dessinerTemple(Temple temple) {
        Position position = temple.getPos();
        double posX = position.getAbscisse() * CARRE+1;
        double posY = position.getOrdonnee() * CARRE+1;
        System.out.println("Dessiner temple à : (" + posX + ", " + posY + ")");
        graphicsContext2D.setFill(COULEUR_CANVAS);
        graphicsContext2D.fillRect(posX, posY, CARRE, CARRE);
    }


    public void effacerTout() {
        graphicsContext2D.clearRect(0, 0, LARGEUR_CANVAS, HAUTEUR_CANVAS);
        dessinerGrille();
    }
}
