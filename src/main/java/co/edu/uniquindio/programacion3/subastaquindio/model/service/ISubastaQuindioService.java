package co.edu.uniquindio.programacion3.subastaquindio.model.service;

import co.edu.uniquindio.programacion3.subastaquindio.exceptions.*;
import co.edu.uniquindio.programacion3.subastaquindio.model.*;

import java.util.ArrayList;

public interface ISubastaQuindioService {


    Producto crearProducto(String codigoUnico, String nombreProducto, String tipoProducto,
                           String foto, String nombreAnunciante) throws ProductoException;

    Boolean eliminarProducto(String codigoUnico) throws ProductoException;

    Boolean eliminarUsuario(String nombreUsuario) throws UsuarioException;

    Boolean eliminarAnunciante(String cedula) throws AnuncianteException;

    Boolean eliminarComprador(String cedula) throws CompradorException;

    boolean actualizarProducto(String codigoUnico, Producto producto) throws ProductoException;

    boolean actualizarUsuario(String nombreUsuario, Usuario usuario) throws UsuarioException;

    boolean actualizarAnunciante(String cedula, Anunciante anunciante) throws AnuncianteException;

    boolean actualizarComprador(String cedula, Comprador comprador) throws CompradorException;

    boolean verificarProductoExistente(String codigoUnico) throws ProductoException;

    boolean verificarUsuarioExistente(String nombreUsuario) throws UsuarioException;

    boolean verificarAnuncianteExistente(String cedula) throws AnuncianteException;

    boolean verificarCompradorExistente(String cedula) throws CompradorException;

    boolean usuarioExiste(String nombreUsuario, String password);

    Producto obtenerProducto(String cedula);

    Usuario obtenerUsuario(String nombreUsuario);

    Anunciante obtenerAnunciante(String cedula);

    Comprador obtenerComprador(String cedula);

    ArrayList<Producto> obtenerProductos();


    Anuncio obtenerAnuncio(String cedula);

    String obtenerEstadoAnuncio(String codigo);

    boolean anuncioExiste(String codigo);

    boolean verificarAnuncioExistente(String codigo) throws AnuncioException;

    boolean actualizarAnuncio(String codigo, Anuncio anuncio) throws AnuncioException;

    Boolean eliminarAnuncio(String cedula) throws AnuncioException;
}
