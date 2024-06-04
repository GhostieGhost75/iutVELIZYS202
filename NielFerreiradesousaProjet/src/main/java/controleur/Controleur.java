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

public class Controleur implements EventHandler {
    @Override
    public void handle(Event event) {
        Object userData = ((MenuItem) event.getSource()).getUserData();
        if (userData instanceof File) {
            File fichierScenario = (File) userData;
            System.out.println("Fichier sélectionné : " + fichierScenario.getName());
            TreeMap<Position, Temple> temples = LectureScenario.lecture(fichierScenario);
            System.out.println("Nombre de temples lus : " + temples.size());
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
                System.out.println("Temple à la position : " + temples.get(temple).getPos());
                vboxCanva.dessinerTemple(temples.get(temple));
            }
        }
    }
    public void handleMenuItemActionManuel(Event event){
        StackpaneMode stackpaneMode = HBoxRoot.getStackpaneMode();
        if (stackpaneMode.getChildren().get(0).equals(stackpaneMode.getVueModemanuel())){
            stackpaneMode.getChildren().get(0).toFront();
            }
        if (stackpaneMode.getChildren().get(1).equals(stackpaneMode.getVueModemanuel())){
            stackpaneMode.getChildren().get(1).toFront();
        }



    }
    public void handleMenuItemActionHeuristique(Event event){
        StackpaneMode stackpaneMode = HBoxRoot.getStackpaneMode();
        if (stackpaneMode.getChildren().get(0).equals(stackpaneMode.getvuemodeHeuristique())) {
            stackpaneMode.getChildren().get(0).toFront();
        }
        if (stackpaneMode.getChildren().get(1).equals(stackpaneMode.getvuemodeHeuristique())){
            stackpaneMode.getChildren().get(1).toFront();
        }


    }
    public void handleMenuItemActionTriselect(ActionEvent event) {
        StackpaneMode stackpaneMode = HBoxRoot.getStackpaneMode();
        if (stackpaneMode.getChildren().get(0).equals(stackpaneMode.getVueModeAlgoTriselection())) {
            stackpaneMode.getChildren().get(0).toFront();
        }
        if (stackpaneMode.getChildren().get(1).equals(stackpaneMode.getVueModeAlgoTriselection())){
            stackpaneMode.getChildren().get(1).toFront();
        }


    }

    public void handleButtonClick(ActionEvent event) {
        VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
        Player joueur = HBoxRoot.getApprenti();
        joueur.permutation();
        vboxCanva.afficherJoueur(joueur);

    }

    public void handleButtonClickHeuristique(ActionEvent event) {
        VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
        Player joueur = HBoxRoot.getApprenti();
        LinkedList<Position> parcour  = Algorithmes.heuristique(joueur);
        HBoxRoot.getStackpaneMode().getvuemodeHeuristique().labelNbdepasattendus.setText( "Nombre de pas attendus : "+Algorithmes.longueurParcoursAlgo(parcour));
        vboxCanva.deplacementAvecTimerListeChemin(parcour);
        vboxCanva.deplacementAvecTimerListe(parcour);
        }


    public void handleButtonClickTriSelection(ActionEvent event) {
        VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
        Player joueur = HBoxRoot.getApprenti();
        LinkedList<Position> parcour  = Algorithmes.TriSelect(joueur);
        HBoxRoot.getStackpaneMode().getVueModeAlgoTriselection().labelNbdepasattendus.setText( "Nombre de pas attendus : "+Algorithmes.longueurParcoursAlgo(parcour));
        vboxCanva.deplacementAvecTimerListeChemin(parcour);
        vboxCanva.deplacementAvecTimerListe(parcour);
    }


}

