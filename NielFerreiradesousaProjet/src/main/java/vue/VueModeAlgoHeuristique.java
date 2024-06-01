package vue;

import controleur.Controleur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class VueModeAlgoHeuristique extends HBox {
    Controleur controleur;
    Label labelHeuristique;
    Button boutonAlgo;
    VueModeAlgoHeuristique(){
        controleur = new Controleur();
        labelHeuristique =new Label("Mode manuel");
        boutonAlgo = new Button("Lancement_Algo");
        //boutonAlgo.setOnAction(event -> controleur.handleButtonC(event));
        this.getChildren().add(labelHeuristique);
        this.getChildren().add(boutonAlgo);
    }
}
