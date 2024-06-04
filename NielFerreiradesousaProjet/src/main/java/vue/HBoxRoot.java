package vue;

import controleur.Controleur;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import modele.Player;

import java.io.File;

/** Classe représentant l'ensemble de la fenêtre et combinant toutes les vues */
public class HBoxRoot extends HBox implements ConstantesCanvas {

    /** objet Player : l'apprenti ordonnateur, le joueur */
    private static Player apprenti;

    /** objet Controleur : le controleur de l'application */
    private static Controleur controleur;

    /** objet VBoxCanva : la grille du jeu */
    private static VboxCanva vueCanvas;

    /** objet StackpaneMode : affiche les boutons nécessaires pour chaque mode */
    private static StackpaneMode stackpaneMode;

    /** Constructeur de l'objet HBoxRoot : permet d'afficher et combiner toutes les vues de l'application */
    public HBoxRoot() {
        apprenti = new Player();
        controleur = new Controleur();

        //barre de menus
        MenuBar menuBar = new MenuBar();
        this.getChildren().add(menuBar);
        VBox.setMargin(menuBar, new Insets(9));

        //menu des scénarios
        Menu menuScenarios = new Menu("INTITULE_MENU_SCENARIOS");
        menuBar.getMenus().add(menuScenarios);

        //les items du menu scénario
        File[] scenarios = new File("maps").listFiles();
        for (File scenario : scenarios) {
            MenuItem menuItem = new MenuItem(scenario.getName());
            menuItem.setUserData(scenario);
            menuItem.setOnAction(controleur);
            menuScenarios.getItems().add(menuItem);
        }
        vueCanvas = new VboxCanva();
        this.getChildren().add(vueCanvas);
        Menu menuMode = new Menu("Mode_apprenti");
        menuBar.getMenus().add(menuMode);
        MenuItem menuItemModeManuel = new MenuItem("modeManuel");
        menuMode.getItems().add(menuItemModeManuel);
        menuItemModeManuel.setOnAction(event -> controleur.handleMenuItemActionManuel(event));
        MenuItem menuItemModeHeuristique = new MenuItem("modeHeuristique");
        menuMode.getItems().add(menuItemModeHeuristique);
        menuItemModeHeuristique.setOnAction(event -> controleur.handleMenuItemActionHeuristique(event));
        MenuItem menuItemModeTriSelection = new MenuItem("modeTriSelect");
        menuMode.getItems().add(menuItemModeTriSelection);
        menuItemModeTriSelection.setOnAction(event -> controleur.handleMenuItemActionTriselect(event));
        stackpaneMode =new StackpaneMode();
        this.getChildren().add(stackpaneMode);
    }


    /**
     * Permet de récupérer l'apprenti ordonnateur
     * @return objet Player : l'apprenti ordonnateur
     */
    public static Player getApprenti() {return apprenti;}

    /**
     * Permet de récupérer la vue de la grille (VboxCanva)
     * @return objet VboxCanva : la grille de l'application
     */
    public static VboxCanva getVboxCanva() {return vueCanvas;}

    /**
     * Permet de récupérer la vue des boutons de chaque mode (StackpaneMode)
     * @return objet StackpaneMode : les boutons pour chaque mode
     */
    public static StackpaneMode getStackpaneMode(){return stackpaneMode;}

}
