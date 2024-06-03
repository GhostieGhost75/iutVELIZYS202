package vue;

import javafx.scene.layout.StackPane;

public class StackpaneMode extends StackPane {
    VueModemanuel vueModemanuel;
    VueModeAlgoHeuristique vueModeAlgoHeuristique;
    VueModeAlgoTriselection vueModeAlgoTriselection;

    StackpaneMode(){

        vueModemanuel =new VueModemanuel();
        vueModemanuel.setStyle("-fx-background-color: #f4f4f4");
        vueModeAlgoHeuristique= new VueModeAlgoHeuristique();
        vueModeAlgoHeuristique.setStyle("-fx-background-color: #f4f4f4");
        vueModeAlgoTriselection=new VueModeAlgoTriselection();
        vueModeAlgoTriselection.setStyle("-fx-background-color: #f4f4f4");
        this.getChildren().add(vueModemanuel);
        this.getChildren().add(vueModeAlgoHeuristique);
        this.getChildren().add(vueModeAlgoTriselection);
    }

    public VueModemanuel getVueModemanuel() {
        return vueModemanuel;
    }

    public VueModeAlgoHeuristique getvuemodeHeuristique() {
        return vueModeAlgoHeuristique;
    }

    public VueModeAlgoTriselection getVueModeAlgoTriselection() {return vueModeAlgoTriselection;}
}
