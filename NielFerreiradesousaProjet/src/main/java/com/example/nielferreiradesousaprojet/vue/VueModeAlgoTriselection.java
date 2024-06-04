package com.example.nielferreiradesousaprojet.vue;

import com.example.nielferreiradesousaprojet.controleur.Controleur;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/** Classe créant la vertical box affichant les boutons liés à l'exécution de l'algorithme TriSelect */
public class VueModeAlgoTriselection extends VBox {

    /** objet Controleur : le controleur de l'application */
    Controleur controleur;

    /** objet Label : le titre du mode */
    Label labelTriselect;

    /** objet Label : le nombre de pas de l'exécution */
    public Label labelNbdepasattendus;

    /** objet Button : bouton d'exécution de l'algorithme */
    Button boutonAlgo;

    /**
     * Constructeur de l'objet VueModeTriselection : affiche les éléments nécessaire lors de l'utilisation
     * de l'algorithme TriSelect (bouton d'exécution, compteur de pas)
     */
    VueModeAlgoTriselection(){
        controleur = new Controleur();
        labelTriselect =new Label("Mode Tri sélection");
        boutonAlgo = new Button("Lancement_Algo");
        labelNbdepasattendus = new Label("Nombre de pas attendus : ");
        boutonAlgo.setOnAction(event -> controleur.handleButtonClickTriSelection(event));
        this.getChildren().add(labelTriselect);
        this.getChildren().add(boutonAlgo);
        this.getChildren().add(labelNbdepasattendus);
        }
    }

