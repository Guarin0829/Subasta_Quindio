package co.edu.uniquindio.programacion3.subastaquindio.controller.service;

import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.*;
import co.edu.uniquindio.programacion3.subastaquindio.model.Anuncio;

import java.util.List;

public interface IModelFactoryService {


    List<ProductoDTO> obtenerProductos();

    String obtenerProducto(String nombre);

    List<UsuarioDto> obtenerUsuarios();

    List<AnuncianteDto> obtenerAnunciantes();

    List<CompradorDto> obtenerCompradores();

    boolean agregarProducto(ProductoDTO productoDto);

    boolean agregarAnunciante(AnuncianteDto anuncianteDto);

    boolean agregarComprador(CompradorDto compradorDto);

    boolean eliminarProducto(String codigoUnico);

    boolean eliminarAnunciante(String cedula);

    boolean eliminarComprador(String cedula);

    boolean actualizarProducto(String cedulaActual, ProductoDTO productoDto);

    boolean agregarUsuario(UsuarioDto usuarioDto);

    boolean eliminarUsuario(String nombreUsuario);

    boolean actualizarUsuario(String nombreUsuario, UsuarioDto usuarioDto);

    boolean actualizarAnunciante(String cedula, AnuncianteDto anuncianteDto);

    boolean actualizarComprador(String cedulaActual, CompradorDto compradorDto);

    boolean inicioSesion(String usuario, String password) throws Exception;

    boolean validarEdadAnunciante(AnuncianteDto anuncianteDto);

    boolean validarEdadComprador(CompradorDto compradorDto);

    List<AnuncioDto> obtenerAnuncio();

    String obtenerEstadoAnuncio(String codigo);

    boolean agregarAnuncio(AnuncioDto anuncioDto);

    boolean actualizarAnuncio(String codigoActual, AnuncioDto anuncioDto);

    boolean eliminarAnuncio(String codigo);

    List<AnuncioDto> obtenerAnuncios();

    List<PujaDto> obtenerPujas();

    boolean actualizarPuja(String codigo, PujaDto pujaDto);

    boolean agregarPuja(PujaDto pujaDto);

    List<ChatDto> obtenerChats();


    CompradorDto obtenerComprador(String nombre);

    Anuncio obtenerAnuncio(String codigo);



    void producirMensaje(String queue, String message);
}
