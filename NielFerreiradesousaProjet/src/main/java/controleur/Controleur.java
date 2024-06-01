package controleur;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import modele.LectureScenario;
import modele.Player;
import modele.Position;
import modele.Temple;
import vue.VBoxRoot;
import vue.VboxCanva;
import vue.VueModemanuel;

import java.io.File;
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
            Player joueur = VBoxRoot.getApprenti();
            joueur.setTemples(temples);
            VboxCanva vboxCanva = VBoxRoot.getVboxCanva();
            vboxCanva.effacerTout();
            joueur.reset();
            vboxCanva.labelNombreDePas.setText("Nombre de pas : " + joueur.getNombreDePas());
            vboxCanva.cliquemouv(new Position(joueur.getAbscisse(), joueur.getOrdonnee()), joueur);
            vboxCanva.effacerTout();
            vboxCanva.afficherJoueur(joueur);
            for (Position temple : temples.keySet()) {
                System.out.println("Temple à la position : " + temples.get(temple).getPos());
                vboxCanva.dessinerTemple(temples.get(temple));
            }


        }
    }

    public void handleButtonClick(ActionEvent event) {
        VboxCanva vboxCanva = VBoxRoot.getVboxCanva();
        Player joueur = VBoxRoot.getApprenti();
        joueur.permutation();
        vboxCanva.afficherJoueur(joueur);

    }
}
