package vue;

import controleur.Controleur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VueModeAlgoTriselection extends VBox {
    Controleur controleur;
    Label labelTriselect;
    Button boutonAlgo;
    VueModeAlgoTriselection(){
        controleur = new Controleur();
        labelTriselect =new Label("Mode_tri_selection");
        boutonAlgo = new Button("Lancement_Algo");
        boutonAlgo.setOnAction(event -> controleur.handleButtonCTri(event));
        this.getChildren().add(labelTriselect);
        this.getChildren().add(boutonAlgo);
        }
    }

