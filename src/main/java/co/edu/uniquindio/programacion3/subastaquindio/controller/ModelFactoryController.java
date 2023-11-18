package co.edu.uniquindio.programacion3.subastaquindio.controller;

import co.edu.uniquindio.programacion3.subastaquindio.controller.service.IModelFactoryService;
import co.edu.uniquindio.programacion3.subastaquindio.exceptions.*;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.CompradorDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.UsuarioDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.mappers.SubastaMapper;
import co.edu.uniquindio.programacion3.subastaquindio.model.*;
import co.edu.uniquindio.programacion3.subastaquindio.utils.Persistencia;
import co.edu.uniquindio.programacion3.subastaquindio.utils.SubastaUtils;

import java.io.IOException;
import java.util.List;


public class ModelFactoryController implements IModelFactoryService {

    SubastaQuindio subasta;
    SubastaMapper mapper = SubastaMapper.INSTANCE;

    //------------------------------  Singleton ------------------------------------------------
    // Clase estatica oculta. Tan solo se instanciara el singleton una vez
    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }

    // Método para obtener la instancia de nuestra clase
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }

    public ModelFactoryController() {
        //1. inicializar datos y luego guardarlo en archivos
        System.out.println("invocación clase singleton");

        //cargarDatosBase();
        //salvarDatosPrueba();

        //2. Cargar los datos de los archivos
        //cargarDatosDesdeArchivos();

        //3. Guardar y Cargar el recurso serializable binario
        //cargarResourceBinario();
        //guardarResourceBinario();

        //4. Guardar y Cargar el recurso serializable XML

        //guardarResourceXML();
        //guardarRespaldoXML();
        cargarResourceXML();
        guardarRespaldosArchivos();

        //Siempre se debe verificar si la raiz del recurso es null

        if(subasta == null){
            cargarDatosBase();
            guardarResourceXML();
            guardarRespaldosArchivos();
        }
        registrarAccionesSistema("Inicio de sesión", 1, "inicioSesión");

    }

    private void cargarDatosDesdeArchivos() {
        subasta = new SubastaQuindio();
        try {
            Persistencia.cargarDatosArchivos(subasta);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void guardarRespaldosArchivos(){
        Persistencia.copiarArchivoRespaldoXml();
    }

    private void salvarDatosPrueba() {
        try {
            Persistencia.guardarProducto(getSubasta().getListaProductos());
            //Persistencia.guardarAnunciante(getSubasta().getListaAnunciantes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void cargarDatosBase() {
        subasta = SubastaUtils.inicializarDatos();
    }

    public SubastaQuindio getSubasta() {
        return subasta;
    }

    public void setSubasta(SubastaQuindio subasta) {
        this.subasta = subasta;
    }


    @Override
    public List<ProductoDTO> obtenerProductos() {
        return  mapper.getProductoDto(subasta.getListaProductos());
    }

    @Override
    public List<UsuarioDto> obtenerUsuarios() {
        return  mapper.getUsuarioDto(subasta.getListaUsuarios());
    }

    @Override
    public List<AnuncianteDto> obtenerAnunciantes() {
        return  mapper.getAnuncianteDto(subasta.getListaAnunciantes());
    }

    @Override
    public List<CompradorDto> obtenerCompradores() {
        return  mapper.getCompradorDto(subasta.getListaCompradores());
    }

    @Override
    public boolean agregarProducto(ProductoDTO productoDto) {
        try{
            if(!subasta.verificarProductoExistente(productoDto.codigoUnico())) {
                Producto producto = mapper.productoDtoToProducto(productoDto);
                getSubasta().agregarProducto(producto);
                guardarResourceXML();
            }
            return true;
        }catch (ProductoException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarProducto(String codigoUnico) {
        boolean flagExiste = false;
        try {
            flagExiste = getSubasta().eliminarProducto(codigoUnico);
            guardarResourceXML(); //Pendiente verificar si este método es adecuado
        } catch (ProductoException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarProducto(String codigoActual, ProductoDTO productoDto) {
        try {
            Producto producto = mapper.productoDtoToProducto(productoDto);
            getSubasta().actualizarProducto(codigoActual, producto);
            guardarResourceXML(); //Pendiente verificar si este método es adecuado
            return true;
        } catch (ProductoException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregarUsuario(UsuarioDto usuarioDto) {
        try{
            if(!subasta.verificarUsuarioExistente(usuarioDto.usuario())) {
                Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
                getSubasta().agregarUsuario(usuario);
                guardarResourceXML();
            }
            return true;
        }catch (UsuarioException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarUsuario(String nombreUsuario) {
        boolean flagExiste = false;
        try {
            flagExiste = getSubasta().eliminarUsuario(nombreUsuario);
            guardarResourceXML(); //Pendiente verificar si este método es adecuado
        } catch (UsuarioException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarUsuario(String nombreUsuario, UsuarioDto usuarioDto) {
        try {
            Usuario usuario = mapper.usuarioDtoToUsuario(usuarioDto);
            getSubasta().actualizarUsuario(nombreUsuario, usuario);
            guardarResourceXML(); //Pendiente verificar si este método es adecuado
            return true;
        } catch (UsuarioException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregarAnunciante(AnuncianteDto anuncianteDto) {
        try{
            if(!subasta.verificarAnuncianteExistente(anuncianteDto.cedula())) {
                Anunciante anunciante = mapper.anuncianteDtoToAnunciante(anuncianteDto);
                getSubasta().agregarAnunciante(anunciante);
                guardarResourceXML();
            }
            return true;
        }catch (AnuncianteException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarAnunciante(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getSubasta().eliminarAnunciante(cedula);
            guardarResourceXML(); //Pendiente verificar si este método es adecuado
        } catch (AnuncianteException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarAnunciante(String cedula, AnuncianteDto anuncianteDto) {
        try {
            Anunciante anunciante = mapper.anuncianteDtoToAnunciante(anuncianteDto);
            getSubasta().actualizarAnunciante(cedula, anunciante);
            guardarResourceXML(); //Pendiente verificar si este método es adecuado
            return true;
        } catch (AnuncianteException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean agregarComprador(CompradorDto compradorDto) {
        try{
            if(!subasta.verificarCompradorExistente(compradorDto.cedula())) {
                Comprador comprador = mapper.compradorDtoToComprador(compradorDto);
                getSubasta().agregarComprador(comprador);
                guardarResourceXML();
            }
            return true;
        }catch (CompradorException e){
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean eliminarComprador(String cedula) {
        boolean flagExiste = false;
        try {
            flagExiste = getSubasta().eliminarComprador(cedula);
            guardarResourceXML(); //Pendiente verificar si este método es adecuado
        } catch (CompradorException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return flagExiste;
    }

    @Override
    public boolean actualizarComprador(String cedulaActual, CompradorDto compradorDto) {
        try {
            Comprador comprador = mapper.compradorDtoToComprador(compradorDto);
            getSubasta().actualizarComprador(cedulaActual, comprador);
            guardarResourceXML(); //Pendiente verificar si este método es adecuado
            return true;
        } catch (CompradorException e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean inicioSesion(String usuario, String password) {
        return getSubasta().inicioSesion(usuario, password);
    }

    @Override
    public boolean validarEdadAnunciante(AnuncianteDto anuncianteDto){
        try{
            Anunciante anunciante = mapper.anuncianteDtoToAnunciante(anuncianteDto);
            getSubasta().esMayor(anunciante);
            return true;
        } catch (PersonaException e) {
            e.getMessage();
            return false;
        }
    }

    @Override
    public boolean validarEdadComprador(CompradorDto compradorDto){
        try{
            Comprador comprador = mapper.compradorDtoToComprador(compradorDto);
            getSubasta().esMayor(comprador);
            return true;
        } catch (PersonaException e) {
            e.getMessage();
            return false;
        }
    }

    private void cargarResourceXML() {
        subasta = Persistencia.cargarRecursoSubastaXML();
    }

    private void guardarResourceXML() {
        Persistencia.guardarRecursoSubastaXML(subasta);
    }


    private void cargarResourceBinario() {
        subasta = Persistencia.cargarRecursoSubastaBinario();
    }

    private void guardarResourceBinario() {
        Persistencia.guardarRecursoSubastaBinario(subasta);
    }

    public void registrarAccionesSistema(String mensaje, int nivel, String accion) {
        Persistencia.guardaRegistroLog(mensaje, nivel, accion);
    }


}
