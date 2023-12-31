package co.edu.uniquindio.programacion3.subastaquindio.viewController;

import co.edu.uniquindio.programacion3.subastaquindio.controller.InicioController;
import co.edu.uniquindio.programacion3.subastaquindio.model.SubastaApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class InicioViewController {

    InicioController inicioController = new InicioController();
    SubastaApplication app = new SubastaApplication();

    public static boolean sesionActiva = false;

    public static String usuarioLogeado = "";
    public static String rolUsuarioLogeado = "";

    public static String cedulaUsuario = "";

    @FXML
    private Button btnIniciarSesion;

    @FXML
    private PasswordField pwfPassword;

    @FXML
    private TextField txfNombreUsuario;

    @FXML
    void siguienteVentana(ActionEvent event) {
        inicioSesion();
    }

    private void inicioSesion(){

        String usuario = txfNombreUsuario.getText();
        String password = pwfPassword.getText();
        boolean permitirIngreso = inicioController.inicioSesion(usuario, password);

        if(permitirIngreso){
            registrarAcciones("Inicio de sesión, usuario: " + usuario,1, "Inicio Sesión");
            sesionActiva = true;
            usuarioLogeado = usuario;
            cerrarVentana(btnIniciarSesion);
            app.cargarTabuladores();
        }else{
            registrarAcciones("Inicio de sesión incorrecto",1, "Inicio sesión");
            mostrarMensaje("Notificación inicio sesión", "Inicio sesión incorrecto", "usuario o contraseña incorrecta", Alert.AlertType.ERROR);
        }

    }

    private void registrarAcciones(String mensaje, int nivel, String accion) {
        inicioController.registrarAcciones(mensaje, nivel, accion);
    }

    public void cerrarVentana(Button btn) {
        Stage stage = (Stage) btn.getScene().getWindow();
        stage.close();
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }

    public boolean sesionActiva(){
        return sesionActiva;
    }

}
