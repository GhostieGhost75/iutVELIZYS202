module com.example.nielferreiradesousaprojet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javafx.graphics;

    requires org.junit.jupiter.api;

    opens com.example.nielferreiradesousaprojet to javafx.fxml;
    exports com.example.nielferreiradesousaprojet.controleur;
    exports com.example.nielferreiradesousaprojet.modele;
    exports com.example.nielferreiradesousaprojet.vue;
}