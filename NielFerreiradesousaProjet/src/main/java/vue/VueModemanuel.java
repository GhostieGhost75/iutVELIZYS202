package vue;

import controleur.Controleur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class VueModemanuel extends HBox {
    Controleur controleur;
    Label labelmanuel;
    Button boutonPermutation;
    VueModemanuel(){
        controleur = new Controleur();
       labelmanuel =new Label("Mode manuel");
       boutonPermutation = new Button("Permutation");
       boutonPermutation.setOnAction(event -> controleur.handleButtonClick(event));
       this.getChildren().add(labelmanuel);
       this.getChildren().add(boutonPermutation);
    }

}
