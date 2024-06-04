package vue;

import controleur.Controleur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;

/** Classe créant la vertical box affichant les boutons liés au mode manuel */
public class VueModemanuel extends VBox {

    /** objet Controleur : le controleur de l'application */
    Controleur controleur;

    /** objet Label : le titre du mode */
    Label labelmanuel;

    /** objet Button : bouton permettant de permuter les cristaux */
    Button boutonPermutation;

    /**
     * Constructeur de l'objet VueModeManuel : affiche les éléments nécessaire lors de l'utilisation
     * du mode manuel (bouton de permutation)
     */
    VueModemanuel(){
        controleur = new Controleur();
        labelmanuel =new Label("Mode Manuel");
        boutonPermutation = new Button("Récupérer le cristal");
        boutonPermutation.setOnAction(event -> controleur.handleButtonClick(event));
        this.getChildren().add(labelmanuel);
        this.getChildren().add(boutonPermutation);

    }

}
