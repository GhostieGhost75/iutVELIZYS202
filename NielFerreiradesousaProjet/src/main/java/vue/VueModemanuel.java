package vue;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class VueModemanuel extends VBox {
    Label labelmanuel ;
    Button boutonPermutation;
    VueModemanuel(){
       labelmanuel =new Label("Mode manuel");
       boutonPermutation = new Button("Permutation");
       this.getChildren().add(labelmanuel);
       this.getChildren().add(boutonPermutation);
    }

}
