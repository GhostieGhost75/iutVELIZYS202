package vue;

import controleur.Controleur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VueModeAlgoHeuristique extends VBox {
    Controleur controleur;
    Label labelHeuristique;
    Button boutonAlgo;
    VueModeAlgoHeuristique(){
        controleur = new Controleur();
        labelHeuristique =new Label("Mode >Heuristique");
        boutonAlgo = new Button("Lancement_Algo");
        //boutonAlgo.setOnAction(event -> controleur.handleButtonC(event));
        this.getChildren().add(labelHeuristique);
        this.getChildren().add(boutonAlgo);
    }
}
