package co.edu.uniquindio.programacion3.subastaquindio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InicioView.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 750, 500);
        stage.setTitle("Subasta Quindio!");
        stage.setScene(scene);
        stage.show();
    }

    public void cargarVentanaInicio() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("InicioView.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            //Image iconImage = new Image("file:///resources/co/edu/uniquindio/programacion3/subastaquindio/img/logo.PNG");
            //newStage.getIcons().add(iconImage);
            newStage.setTitle("Subastas Quindío | Inicio");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void cargarTabuladores() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("SubastaView.fxml"));
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            Stage newStage = new Stage();
            newStage.centerOnScreen();
            //Image iconImage = new Image("file:///resources/co/edu/uniquindio/programacion3/subastaquindio/img/logo.PNG");
            //newStage.getIcons().add(iconImage);
            newStage.setTitle("Subastas Quindío | Inicio");
            newStage.setResizable(false);
            newStage.setScene(scene);
            newStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}