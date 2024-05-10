package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.geometry.Rectangle2D;
import javafx.scene.layout.StackPane;
import javafx.stage.Screen;
import java.io.File;

public class ProjetApplication extends Application {
    public void start(Stage stage) {
        Rectangle2D screenSize = Screen.getPrimary().getBounds();//obtient la taille de l'écran
        stage.setWidth(screenSize.getWidth());
        stage.setHeight(screenSize.getHeight()/1.03);//divisés par 3% car sinon la taille de la fenetre dépasse un peu la taille de l'écran
        VBox root = new vue.VboxCanva();
        Scene scene = new Scene(root, screenSize.getHeight()/1.03,screenSize.getWidth());
        stage.setScene(scene);
        stage.setTitle("APPRENTI ORDONNATEUR");
        stage.show();
    }
    public static void main (String [] args) {
        Application.launch(args);
    }
}