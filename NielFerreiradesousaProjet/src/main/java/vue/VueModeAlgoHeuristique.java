package vue;

import controleur.Controleur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VueModeAlgoHeuristique extends VBox {
    Controleur controleur;
    Label labelHeuristique;
    public Label labelNbdepasattendus;
    Button boutonAlgo;
    VueModeAlgoHeuristique(){
        controleur = new Controleur();
        labelHeuristique =new Label("Mode >Heuristique");
        labelNbdepasattendus = new Label("Nombre de pas attendus : ");
        boutonAlgo = new Button("Lancement_Algo");
        boutonAlgo.setOnAction(event -> controleur.handleButtonClickHeuristique(event));
        this.getChildren().add(labelHeuristique);
        this.getChildren().add(boutonAlgo);
        this.getChildren().add(labelNbdepasattendus);
    }
}
