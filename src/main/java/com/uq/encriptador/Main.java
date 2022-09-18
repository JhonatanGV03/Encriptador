package com.uq.encriptador;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("interfaz.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 350, 400);
        Image icon = new Image(Objects.requireNonNull(getClass().getResourceAsStream("/com/uq/encriptador/key.png")));
        stage.getIcons().add( icon );
        stage.setResizable(false);
        stage.setTitle("Encriptador");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}