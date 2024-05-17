package vue;


import javafx.geometry.Insets;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.canvas.GraphicsContext;
import vue.ConstantesCanvas;

public class VboxCanva extends VBox implements ConstantesCanvas {
    public Canvas canvasCarte;
    public Label labelNombreDePas;

    public GraphicsContext graphicsContext2D;

    public VboxCanva(){
        labelNombreDePas= new Label ("Nombre de pas : 0");
        canvasCarte = new Canvas();
        canvasCarte.setWidth(LARGEUR_CANVAS);
        canvasCarte.setHeight(HAUTEUR_CANVAS);
        graphicsContext2D = canvasCarte.getGraphicsContext2D();

        graphicsContext2D.setStroke(COULEUR_CANVAS);
        for (int i=0; i<LARGEUR_CANVAS;i+=CARRE){
            for (int j=0; j<HAUTEUR_CANVAS;j+=CARRE){
                graphicsContext2D.strokeRect(i,j,CARRE,CARRE);

            }
        }
        int numCol= 0;
        graphicsContext2D.setFill(COULEUR_CANVAS);
        for (double i = CARRE; i<LARGEUR_CANVAS; i+=CARRE){
            graphicsContext2D.fillText(Integer.toString(numCol),i+CARRE/3,CARRE/2);
            numCol++;
        }
        int numLigne = 0;
        graphicsContext2D.setFill(COULEUR_CANVAS);
        for(double i = CARRE; i<HAUTEUR_CANVAS; i+= CARRE){
            graphicsContext2D.fillText(Integer.toString(numLigne),CARRE/3,i+CARRE/2);
            numLigne++;
        }

        this.getChildren().add(labelNombreDePas);
        VBox.setMargin(labelNombreDePas, new Insets(30));
        this.getChildren().add(canvasCarte);
        VBox.setMargin(canvasCarte,new Insets(30));




    }


}
