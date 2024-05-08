module com.example.nielferreiradesousaprojet {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires javatuples;

    opens com.example.nielferreiradesousaprojet to javafx.fxml;
    exports com.example.nielferreiradesousaprojet;
}