package vue;

import javafx.scene.layout.StackPane;

/** Classe fille de StackPane : permet d'afficher les différentes vues liées aux différents modes */
public class StackpaneMode extends StackPane {

    /** objet VueModeManuel : VBox contenant les éléments nécessaires pour l'utilisation du mode manuel */
    VueModemanuel vueModemanuel;

    /** objet VueModeAlgoHeuristique : VBox contenant les éléments nécessaires à l'exécution de l'algorithme Heuristique */
    VueModeAlgoHeuristique vueModeAlgoHeuristique;

    /** objet VueModeTriSelection : VBox contenant les éléments nécessaires à l'exécution de l'algorithme TriSelect */
    VueModeAlgoTriselection vueModeAlgoTriselection;

    /**
     * Constructeur de l'objet StackPaneMode : permet d'afficher les différentes vues de
     * mode en fonction du mode actuellement sélectionné
     */
    StackpaneMode(){

        vueModemanuel =new VueModemanuel();
        vueModemanuel.setStyle("-fx-background-color: #f4f4f4");
        vueModeAlgoHeuristique= new VueModeAlgoHeuristique();
        vueModeAlgoHeuristique.setStyle("-fx-background-color: #f4f4f4");
        vueModeAlgoTriselection=new VueModeAlgoTriselection();
        vueModeAlgoTriselection.setStyle("-fx-background-color: #f4f4f4");
        this.getChildren().add(vueModeAlgoTriselection);
        this.getChildren().add(vueModeAlgoHeuristique);
        this.getChildren().add(vueModemanuel);
    }

    /**
     * Permet de récupérer la vue du mode manuel
     * @return objet VueModemanuel : la vue du mode manuel
     */
    public VueModemanuel getVueModemanuel() {return vueModemanuel;}

    /**
     * Permet de récupérer la vue de l'algorithme Heuristique
     * @return objet VueModeAlgoHeuristique : la vue de l'algorithme Heuristique
     */
    public VueModeAlgoHeuristique getVueModeAlgoHeuristique() {return vueModeAlgoHeuristique;}

    /**
     * Permet de récupérer la vue de l'algorithme TriSelect
     * @return objet VueModeAlgoTriselection : la vue de l'algorithme TriSelect
     */
    public VueModeAlgoTriselection getVueModeAlgoTriselection() {return vueModeAlgoTriselection;}
}
