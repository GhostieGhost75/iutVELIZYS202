module com.example.nielferreiradesousaprojet {
    requires javafx.controls;
    requires javafx.fxml;

    requires javatuples;
    requires org.controlsfx.controls;


    opens com.example.nielferreiradesousaprojet to javafx.fxml;
    exports com.example.nielferreiradesousaprojet;
    exports modele;
}