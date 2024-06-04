package controleur;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import modele.*;
import vue.StackpaneMode;
import vue.HBoxRoot;
import vue.VboxCanva;

import java.io.File;
import java.util.LinkedList;
import java.util.TreeMap;

/**Classe qui fait le lien entre  vue et  modèle*/
public class Controleur implements EventHandler {
    /**Prend en charges les évènement ici cette méthode ne s'occupe que des évènement lié au menu des scénarios*/
    public void handle(Event event) {
        Object userData = ((MenuItem) event.getSource()).getUserData();
        if (userData instanceof File) {
            File fichierScenario = (File) userData;
            TreeMap<Position, Temple> temples = LectureScenario.lecture(fichierScenario);
            Player joueur = HBoxRoot.getApprenti();
            joueur.setTemples(temples);
            VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
            vboxCanva.effacerTout();
            joueur.reset();
            vboxCanva.labelNombreDePas.setText("Nombre de pas : " + joueur.getPosPlayer().getNombreDePas());
            vboxCanva.cliquemouv(joueur);
            vboxCanva.effacerTout();
            vboxCanva.afficherJoueur(joueur);
            for (Position temple : temples.keySet()) {
                vboxCanva.dessinerTemple(temples.get(temple));
            }
        }
    }

    /**Prend en charges les évènement ici cette méthode s'occupe des évènement lié au menu des mode ici pour le manuel */
    public void handleMenuItemActionManuel(Event event){
        StackpaneMode stackpaneMode = HBoxRoot.getStackpaneMode();
        if (stackpaneMode.getChildren().get(0).equals(stackpaneMode.getVueModemanuel())){
            stackpaneMode.getChildren().get(0).toFront();
            }
        if (stackpaneMode.getChildren().get(1).equals(stackpaneMode.getVueModemanuel())){
            stackpaneMode.getChildren().get(1).toFront();
        }



    }
    /**Prend en charges les évènement ici cette méthode s'occupe des évènement lié au menu des mode ici pour l'heuristique */
    public void handleMenuItemActionHeuristique(Event event){
        StackpaneMode stackpaneMode = HBoxRoot.getStackpaneMode();
        if (stackpaneMode.getChildren().get(0).equals(stackpaneMode.getvuemodeHeuristique())) {
            stackpaneMode.getChildren().get(0).toFront();
        }
        if (stackpaneMode.getChildren().get(1).equals(stackpaneMode.getvuemodeHeuristique())){
            stackpaneMode.getChildren().get(1).toFront();
        }


    }
    /**Prend en charges les évènement ici cette méthode s'occupe des évènement lié au menu des mode ici pour le tri selection */
    public void handleMenuItemActionTriselect(ActionEvent event) {
        StackpaneMode stackpaneMode = HBoxRoot.getStackpaneMode();
        if (stackpaneMode.getChildren().get(0).equals(stackpaneMode.getVueModeAlgoTriselection())) {
            stackpaneMode.getChildren().get(0).toFront();
        }
        if (stackpaneMode.getChildren().get(1).equals(stackpaneMode.getVueModeAlgoTriselection())){
            stackpaneMode.getChildren().get(1).toFront();
        }


    }

    /**cette méthode s'occupe du bouton qui permet la permutation */
    public void handleButtonClick(ActionEvent event) {
        VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
        Player joueur = HBoxRoot.getApprenti();
        joueur.permutation();
        vboxCanva.afficherJoueur(joueur);

    }
    /**cette méthode s'occupe du bouton qui permet le lancement de l'algorithme Heuristique */
    public void handleButtonClickHeuristique(ActionEvent event) {
        VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
        Player joueur = HBoxRoot.getApprenti();
        LinkedList<Position> parcour  = Algorithmes.heuristique(joueur);
        HBoxRoot.getStackpaneMode().getvuemodeHeuristique().labelNbdepasattendus.setText( "Nombre de pas attendus : "+Algorithmes.longueurParcoursAlgo(parcour));
        vboxCanva.deplacementAvecTimerListeChemin(parcour);
        vboxCanva.deplacementAvecTimerListe(parcour);
        }

    /**cette méthode s'occupe du bouton qui permet le lancement de l'algorithme qui utilise le Tri selection */
    public void handleButtonClickTriSelection(ActionEvent event) {
        VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
        Player joueur = HBoxRoot.getApprenti();
        LinkedList<Position> parcour  = Algorithmes.TriSelect(joueur);
        HBoxRoot.getStackpaneMode().getVueModeAlgoTriselection().labelNbdepasattendus.setText( "Nombre de pas attendus : "+Algorithmes.longueurParcoursAlgo(parcour));
        vboxCanva.deplacementAvecTimerListeChemin(parcour);
        vboxCanva.deplacementAvecTimerListe(parcour);
    }


}

