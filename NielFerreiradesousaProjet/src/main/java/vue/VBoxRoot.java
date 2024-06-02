package vue;

import controleur.Controleur;
import javafx.application.Platform;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.VBox;
import javafx.geometry.Insets;
import javafx.scene.paint.Paint;
import modele.Player;
import modele.Position;

import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

public class VBoxRoot extends VBox implements ConstantesCanvas {

    private static Player apprenti;
    private static Controleur controleur;
    private static VboxCanva vueCanvas;

    private static StackpaneMode stackpaneMode;
    public GraphicsContext graphicsContext2D;

    public VBoxRoot() {
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
        MenuBar modeBar = new MenuBar();
        this.getChildren().add(modeBar);
        VBox.setMargin(modeBar, new Insets(9));
        Menu menuMode = new Menu("Mode_apprenti");
        modeBar.getMenus().add(menuMode);
        MenuItem menuItemModeManuel = new MenuItem("modeManuel");
        menuMode.getItems().add(menuItemModeManuel);
        menuItemModeManuel.setOnAction(event -> controleur.handleMenuItemActionManuel(event));
        MenuItem menuItemModeHeuristique = new MenuItem("modeHeuristique");
        menuMode.getItems().add(menuItemModeHeuristique);
        menuItemModeHeuristique.setOnAction(event -> controleur.handleMenuItemActionHeuristique(event));
        stackpaneMode =new StackpaneMode();
        this.getChildren().add(stackpaneMode);
    }


    public static Player getApprenti() {
        return apprenti;
    }

    public static VboxCanva getVboxCanva() {
        return vueCanvas;
    }
    public static StackpaneMode getStackpaneMode(){return stackpaneMode;}

}
