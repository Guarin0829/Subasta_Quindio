package co.edu.uniquindio.programacion3.subastaquindio.model;

import co.edu.uniquindio.programacion3.subastaquindio.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class SubastaApplication {
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
}
