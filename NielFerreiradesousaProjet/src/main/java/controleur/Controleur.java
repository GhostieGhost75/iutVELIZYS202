package controleur;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
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

    /** objet int : mode actuel (0 pour manuel, 1 pour heuristique, 2 pour tri sélection) */
    int mode = 0;

    /** vérifie si les cristaux sont bien à leur place, fait apparaître un pop up si c'est le cas */
    public static void checkwin() {
        boolean win = true;
        Player apprenti = HBoxRoot.getApprenti();
        for (Position pos : apprenti.getTemples().keySet()) {
            if (apprenti.getTemples().get(pos).getNum()!= apprenti.getTemples().get(pos).getCristal())
                win = false;
        }
        if (win) {
            Alert alerteVictoire = new Alert(Alert.AlertType.INFORMATION);
            alerteVictoire.setTitle("Société des magiciens");
            alerteVictoire.setHeaderText("Victoire!");
            alerteVictoire.setContentText("L'apprenti ordonnateur a rétabli l'ordre de la magie au royaume de Krystalia! Il recevra une prime de 3 écus HT.\n" +
                    "(il est possible de relancer un scénario si l'envie vous prend)");
            alerteVictoire.show();
        }
    }

    /** affiche une prévisualisation du trajet emprunté par l'algorithme sélectionné */
    public void affPreview() {
        VboxCanva vBoxCanva = HBoxRoot.getVboxCanva();
        Player apprenti = HBoxRoot.getApprenti();
        LinkedList<Position> chemin;
        vBoxCanva.effacerTout();
        for (Position temple : apprenti.getTemples().keySet()) {
            System.out.println("Temple à la position : " + apprenti.getTemples().get(temple).getPos());
            vBoxCanva.dessinerTemple(apprenti.getTemples().get(temple));
        }
        // Mettre à jour l'interface graphique pour la nouvelle position
        vBoxCanva.afficherJoueur(apprenti);
        if (mode == 1) {
            chemin = Algorithmes.heuristique(apprenti);
            vBoxCanva.deplacementAvecTimerListeChemin(chemin);
            HBoxRoot.getStackpaneMode().getVueModeAlgoHeuristique().labelNbdepasattendus.setText("Nombre de pas attendus : "
                    + Algorithmes.longueurParcoursAlgo(chemin));
        }
        else if (mode == 2) {
            chemin = Algorithmes.heuristique(apprenti);
            vBoxCanva.deplacementAvecTimerListeChemin(chemin);
            HBoxRoot.getStackpaneMode().getVueModeAlgoTriselection().labelNbdepasattendus.setText("Nombre de pas attendus : "
                    + Algorithmes.longueurParcoursAlgo(chemin));
        }

    }

    /**Prend en charges les évènement : ici cette méthode ne s'occupe que des évènement lié au menu des scénarios*/
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
            affPreview();
        }
    }

    /**Prend en charges les évènement : ici cette méthode s'occupe des évènement lié au menu des mode ici pour le manuel */
    public void handleMenuItemActionManuel(Event event){
        HBoxRoot.getApprenti().setMoving(false);
        mode = 0;
        StackpaneMode stackpaneMode = HBoxRoot.getStackpaneMode();
        if (stackpaneMode.getChildren().get(0).equals(stackpaneMode.getVueModemanuel())){
            stackpaneMode.getChildren().get(0).toFront();
            }
        if (stackpaneMode.getChildren().get(1).equals(stackpaneMode.getVueModemanuel())){
            stackpaneMode.getChildren().get(1).toFront();
        }
        affPreview();
    }

    /**Prend en charges les évènement : ici cette méthode s'occupe des évènement lié au menu des mode ici pour l'heuristique */
    public void handleMenuItemActionHeuristique(Event event){
        mode = 1;
        HBoxRoot.getApprenti().setMoving(true);
        StackpaneMode stackpaneMode = HBoxRoot.getStackpaneMode();
        if (stackpaneMode.getChildren().get(0).equals(stackpaneMode.getVueModeAlgoHeuristique())) {
            stackpaneMode.getChildren().get(0).toFront();
        }
        if (stackpaneMode.getChildren().get(1).equals(stackpaneMode.getVueModeAlgoHeuristique())){
            stackpaneMode.getChildren().get(1).toFront();
        }
        affPreview();
    }

    /**Prend en charges les évènement : ici cette méthode s'occupe des évènement lié au menu des mode ici pour le tri selection */
    public void handleMenuItemActionTriselect(ActionEvent event) {
        mode = 2;
        HBoxRoot.getApprenti().setMoving(true);
        StackpaneMode stackpaneMode = HBoxRoot.getStackpaneMode();
        if (stackpaneMode.getChildren().get(0).equals(stackpaneMode.getVueModeAlgoTriselection())) {
            stackpaneMode.getChildren().get(0).toFront();
        }
        if (stackpaneMode.getChildren().get(1).equals(stackpaneMode.getVueModeAlgoTriselection())){
            stackpaneMode.getChildren().get(1).toFront();
        }
        affPreview();
    }

    /**cette méthode s'occupe du bouton qui permet la permutation */
    public void handleButtonClick(ActionEvent event) {
        VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
        Player joueur = HBoxRoot.getApprenti();
        joueur.permutation();
        vboxCanva.afficherJoueur(joueur);
        checkwin();
    }

    /**cette méthode s'occupe du bouton qui permet le lancement de l'algorithme Heuristique */
    public void handleButtonClickHeuristique(ActionEvent event) {
        VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
        Player joueur = HBoxRoot.getApprenti();
        LinkedList<Position> parcour  = Algorithmes.heuristique(joueur);
        HBoxRoot.getStackpaneMode().getVueModeAlgoHeuristique().labelNbdepasattendus.setText( "Nombre de pas attendus : "+Algorithmes.longueurParcoursAlgo(parcour));
        vboxCanva.deplacementAvecTimerListe(parcour);
        checkwin();
        }

    /**cette méthode s'occupe du bouton qui permet le lancement de l'algorithme qui utilise le Tri selection */
    public void handleButtonClickTriSelection(ActionEvent event) {
        VboxCanva vboxCanva = HBoxRoot.getVboxCanva();
        Player joueur = HBoxRoot.getApprenti();
        LinkedList<Position> parcour  = Algorithmes.triSelect(joueur);
        HBoxRoot.getStackpaneMode().getVueModeAlgoTriselection().labelNbdepasattendus.setText( "Nombre de pas attendus : "+Algorithmes.longueurParcoursAlgo(parcour));
        vboxCanva.deplacementAvecTimerListe(parcour);
        checkwin();
    }


}

