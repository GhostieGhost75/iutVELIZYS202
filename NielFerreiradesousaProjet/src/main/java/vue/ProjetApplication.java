package vue;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;

public class ProjetApplication extends Application {
    public void start(Stage stage) {
        VBox root = new VboxCanva();
        Scene scene = new Scene(root, 400, 380);
        stage.setScene(scene);
        stage.setTitle("APPRENTI ORDONNATEUR");
        stage.show();
    }
    public static void main (String [] args) {
        Application.launch(args);
    }
}