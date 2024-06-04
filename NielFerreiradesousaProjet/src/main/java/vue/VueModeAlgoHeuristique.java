package vue;

import controleur.Controleur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/** Classe créant la vertical box affichant les boutons liés à l'exécution de l'algorithme Heuristique */
public class VueModeAlgoHeuristique extends VBox {

    /** objet Controleur : le controleur de l'application */
    Controleur controleur;

    /** objet Label : le titre du mode */
    Label labelHeuristique;

    /** objet Label : le nombre de pas de l'exécution */
    public Label labelNbdepasattendus;

    /** objet Button : bouton d'exécution de l'algorithme */
    Button boutonAlgo;

    /**
     * Constructeur de l'objet VueModeAlgoHeuristique : affiche les éléments nécessaire lors de l'utilisation
     * de l'algorithme Heuristique (bouton d'exécution, compteur de pas)
     */
    VueModeAlgoHeuristique(){
        controleur = new Controleur();
        labelHeuristique =new Label("Mode Heuristique");
        labelNbdepasattendus = new Label("Nombre de pas attendus : ");
        boutonAlgo = new Button("Lancement_Algo");
        boutonAlgo.setOnAction(event -> controleur.handleButtonClickHeuristique(event));
        this.getChildren().add(labelHeuristique);
        this.getChildren().add(boutonAlgo);
        this.getChildren().add(labelNbdepasattendus);
    }
}
