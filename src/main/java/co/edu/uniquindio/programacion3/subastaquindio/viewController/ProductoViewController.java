package co.edu.uniquindio.programacion3.subastaquindio.viewController;

import co.edu.uniquindio.programacion3.subastaquindio.controller.ProductoController;
import co.edu.uniquindio.programacion3.subastaquindio.enumm.TipoProducto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;

import java.util.Optional;

public class ProductoViewController {

    ProductoController productoControllerService;

    /**
     * Un arrraylist no es observable en una tabla de jFX
     * ObservableList<>, permite visualizarlo
     */

    ObservableList<ProductoDTO> listaProductosDto = FXCollections.observableArrayList();

    ObservableList<AnuncianteDto> listaAnunciantesDto = FXCollections.observableArrayList();
    ObservableList<String> listaTipoProducto = FXCollections.observableArrayList();

    ProductoDTO productoSeleccionado;

    @FXML
    private ImageView imageViewFoto;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAgregar;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEliminar;

    @FXML
    private TableColumn<ProductoDTO, String> colAnunciante;

    @FXML
    private TableColumn<ProductoDTO, String> colCodigoUnico;

    @FXML
    private TableColumn<ProductoDTO, String> colNombreProducto;

    @FXML
    private TableColumn<ProductoDTO, String> colTipoProducto;



    @FXML
    private TableView<ProductoDTO> tableProductos;

    @FXML
    private ComboBox<AnuncianteDto> cmbAnunciante;

    @FXML
    private ComboBox<String> cmbTipoProducto;

    @FXML
    private TextField txfCodigoUnico;

    @FXML
    private TextField txfNombreProducto;


    @FXML
    void actualizarProducto(ActionEvent event) {
        actualizarProducto();
    }

    @FXML
    void agregarProducto(ActionEvent event) {
        crearProducto();
    }

    @FXML
    void eliminarProducto(ActionEvent event) {
        eliminarProducto();
    }

    @FXML
    void seleccionarImagen(ActionEvent event) {
        seleccionarImagen();
    }

    private void seleccionarImagen() { //Pendiente ruta de imagen
        System.out.println("p");
    }


    @FXML
    void busquedaProducto(ActionEvent event) {
        String codigoUnico = txfCodigoUnico.getText();
        String nombreProducto = txfNombreProducto.getText();
        String nombreAnunciante = String.valueOf(cmbAnunciante.getValue());
        String tipoProducto = cmbTipoProducto.getValue();

 //       buscarProducto(codigoUnico, nombreProducto, nombreAnunciante, tipoProducto);
    }



    private void busquedaProducto() { // método implementado del action event
        System.out.println("Prueba de buscarProducto");
    }



    private void crearProducto(){


        // Capturar los datos
        ProductoDTO productoDTO = construirProductoDto();

        // Validar la información
        if(datosValidos(productoDTO)){
            if(productoControllerService.agregarProducto(productoDTO)){
                listaProductosDto.add(productoDTO);
                mostrarMensaje("notificación productos", "Producto creado", "El producto se ha creado con éxito", Alert.AlertType.INFORMATION);
                limpiarCamposProductos();
                registrarAcciones("Producto agregado",1, "Agregar empleado");
            }else{
                mostrarMensaje("notificación productos", "Producto NO creado", "El producto NO se ha creado con éxito", Alert.AlertType.ERROR);
            }
        }else{
            mostrarMensaje("notificación productos", "Producto NO creado", "Los datos ingresados son inválidos", Alert.AlertType.ERROR);
        }

    }

    private void eliminarProducto() {
        boolean productoEliminado = false;
        if(productoSeleccionado != null){
            if(mostrarMensajeConfirmacion("¿Estas seguro de elmininar el producto?")){
                productoEliminado = productoControllerService.eliminarProducto(productoSeleccionado.codigoUnico());
                if(productoEliminado == true){
                    listaProductosDto.remove(productoSeleccionado);
                    productoSeleccionado = null;
                    tableProductos.getSelectionModel().clearSelection();
                    limpiarCamposProductos();
                    registrarAcciones("Producto eliminado",1, "Eliminar empleado");
                    mostrarMensaje("Notificación producto", "Producto Eliminado", "El producto se ha eliminado con éxito", Alert.AlertType.INFORMATION);
                }else{
                    mostrarMensaje("Notificación producto", "Producto no eliminado", "El producto no se puede eliminar", Alert.AlertType.ERROR);
                }
            }
        }else{
            mostrarMensaje("Notificación producto", "Producto no seleccionado", "Seleccionado un producto de la lista", Alert.AlertType.WARNING);
        }
    }

    private void actualizarProducto() {
        boolean productoActualizado = false;
        //1. Capturar los datos
        String codigoUnico = productoSeleccionado.codigoUnico();
        ProductoDTO productoDto = construirProductoDto();
        //2. verificar el empleado seleccionado
        if(productoSeleccionado != null){
            //3. Validar la información
            if(datosValidos(productoSeleccionado)){
                productoActualizado = productoControllerService.actualizarProducto(codigoUnico,productoDto);
                if(productoActualizado){
                    listaProductosDto.remove(productoSeleccionado);
                    listaProductosDto.add(productoDto);
                    tableProductos.refresh();
                    mostrarMensaje("Notificación producto", "Producto Actualizado", "El producto se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                    limpiarCamposProductos();
                    registrarAcciones("Producto Actualizado",1, "Empleado Actualizado");
                }else{
                    mostrarMensaje("Notificación empleado", "Producto no actualizado", "El producto no se ha actualizado con éxito", Alert.AlertType.INFORMATION);
                }
            }else{
                mostrarMensaje("Notificación producto", "Producto no creado", "Los datos ingresados son invalidos", Alert.AlertType.ERROR);
            }

        }
    }

    private ProductoDTO construirProductoDto(){
        return new ProductoDTO(
                txfCodigoUnico.getText(), // captura lo que se escribe en la tabla
                txfNombreProducto.getText(),
                cmbTipoProducto.getValue(),
                "",
                String.valueOf(cmbAnunciante.getValue())
        );

    }

    public void mostrarTipoProducto(){
        listaTipoProducto.add(String.valueOf(TipoProducto.TECNOLOGIA));
        listaTipoProducto.add(String.valueOf(TipoProducto.HOGAR));
        listaTipoProducto.add(String.valueOf(TipoProducto.DEPORTES));
        listaTipoProducto.add(String.valueOf(TipoProducto.VEHICULOS));
        listaTipoProducto.add(String.valueOf(TipoProducto.BIEN_RAIZ));
        cmbTipoProducto.setItems(listaTipoProducto);
    }

    public ObservableList<AnuncianteDto> getListaAnunciantes() {
        listaAnunciantesDto.addAll(productoControllerService.obtenerAnunciantes());
        return listaAnunciantesDto;
    }

    private void limpiarCamposProductos(){
        txfCodigoUnico.setText("");
        txfNombreProducto.setText("");
        cmbAnunciante.setValue(null);
        cmbTipoProducto.setValue(null);
    }

    private boolean datosValidos(ProductoDTO productoDto){
        String mensaje = "";
        if(productoDto.nombreProducto() == null || productoDto.nombreProducto().equals(""))
            mensaje += "El nombre del Producto es inválido \n" ;
        if(productoDto.nombreAnunciante() == null || productoDto.nombreAnunciante().equals(""))
            mensaje += "El nombre del anunciante es inválido \n" ;
        if(productoDto.codigoUnico() == null || productoDto.codigoUnico().equals(""))
            mensaje += "El código único del anunciate es inválido \n" ;
        if(productoDto.tipoProducto() == null || productoDto.tipoProducto().equals(""))
            mensaje += "El tipo de producto es inválido \n" ;
        if(mensaje.equals("")){
            return true;
        }else{
            mostrarMensaje("Notificación cliente", "Datos inválidos", mensaje, Alert.AlertType.WARNING);
            return false;
        }

    }

    public void mostrarAnunciantes(){
        cmbAnunciante.setItems(listaAnunciantesDto);
    }

    /**
     * Enlaza la columna con el dato, crea una especie de método .codigoUnico etc.
     * método anónimo
     */
    @FXML
    void initialize() {
        productoControllerService = new ProductoController();
        intiView();
    }

    private void intiView() {
        initDataBinding();
        obtenerProductos();
        mostrarTipoProducto();
        mostrarAnunciantes();
        getListaAnunciantes();
        tableProductos.getItems().clear();
        tableProductos.setItems(listaProductosDto);
        listenerSelection();
    }
    private void initDataBinding() {
        colCodigoUnico.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().codigoUnico()));
        colNombreProducto.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreProducto()));
        colAnunciante.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().nombreAnunciante()));
        colTipoProducto.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().tipoProducto())));

    }
    private void obtenerProductos() {
        listaProductosDto.addAll(productoControllerService.obtenerProductos());
    }
    /**
     * Método que identifica dónde se da click, se marca como elemento observable
     * oldselection, pone en azul la línea selecionada.
     */

    private void listenerSelection() {
        tableProductos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            productoSeleccionado = newSelection;
            mostrarInformacionProducto(productoSeleccionado);
        });
    }


    /**
     * Al dar click en la tabla, el elemento seleccionado se resalta en el campo de texto
     * el método listenerSelection llama al método empleadoSeleccionado
     * @param empleadoSeleccionado
     */

    private void mostrarInformacionProducto(ProductoDTO empleadoSeleccionado) {
        if(empleadoSeleccionado != null){
            txfCodigoUnico.setText(productoSeleccionado.codigoUnico());
            txfNombreProducto.setText(productoSeleccionado.nombreProducto());
            cmbAnunciante.setValue(productoSeleccionado.getAnunciante());
            cmbTipoProducto.setValue(productoSeleccionado.tipoProducto());
        }
    }

    private void mostrarMensaje(String titulo, String header, String contenido, Alert.AlertType alertType) {
        Alert aler = new Alert(alertType);
        aler.setTitle(titulo);
        aler.setHeaderText(header);
        aler.setContentText(contenido);
        aler.showAndWait();
    }
    private void registrarAcciones(String mensaje, int nivel, String accion) {
        productoControllerService.registrarAcciones(mensaje, nivel, accion);
    }

    private boolean mostrarMensajeConfirmacion(String mensaje) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setHeaderText(null);
        alert.setTitle("Confirmación");
        alert.setContentText(mensaje);
        Optional<ButtonType> action = alert.showAndWait();
        if (action.get() == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }





}


