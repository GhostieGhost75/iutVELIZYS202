package vue;

import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class StackpaneMode extends StackPane {
    VueModemanuel vuemodemanuel;

    StackpaneMode(){
        vuemodemanuel =new VueModemanuel();
        this.getChildren().add(vuemodemanuel);
    }

}
