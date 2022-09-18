module com.uq.encriptador {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.uq.encriptador to javafx.fxml;
    exports com.uq.encriptador;
}