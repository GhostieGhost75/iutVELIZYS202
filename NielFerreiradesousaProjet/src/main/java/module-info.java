module com.example.nielferreiradesousaprojet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;

    opens com.example.nielferreiradesousaprojet to javafx.fxml;
    exports com.example.nielferreiradesousaprojet;
    exports vue;
    exports modele;
    exports controleur;
}