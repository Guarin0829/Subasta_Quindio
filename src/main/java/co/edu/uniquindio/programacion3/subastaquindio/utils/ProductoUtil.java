package co.edu.uniquindio.programacion3.subastaquindio.utils;

import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.UsuarioDto;

import java.util.function.Predicate;

public class ProductoUtil {

    public static Predicate<ProductoDTO> buscarPorCodigo(String codigo){
        return productoDto -> productoDto.codigoUnico().contains(codigo);
    }
    public static Predicate<ProductoDTO> buscarPorNombreProducto(String nombreProducto){
        return productoDto -> productoDto.nombreProducto().contains(nombreProducto);
    }

    public static Predicate<ProductoDTO> buscarPorNombreAnunciante(String anunciante){
        return productoDto -> productoDto.getAnunciante().toString().contains(anunciante);
    }

    public static Predicate<ProductoDTO> buscarPorTipoProducto(String tipoProducto){
        return productoDto -> productoDto.tipoProducto().contains(tipoProducto);
    }


    public static Predicate<ProductoDTO> buscarPorTodo(String codigoUnico, String nombreProducto, String nombreAnunciante,
                                                       String tipoProducto) {

        Predicate<ProductoDTO> predicado = productoDto -> true;

        if( codigoUnico != null && !codigoUnico.isEmpty() ){
            predicado = predicado.and(buscarPorCodigo(codigoUnico));
        }
        if( nombreProducto != null && !nombreProducto.isEmpty() ){
            predicado = predicado.and(buscarPorNombreProducto(nombreProducto));
        }
        if( nombreAnunciante != null && !nombreAnunciante.isEmpty() && !nombreAnunciante.equals("null")){
            predicado = predicado.and(buscarPorNombreAnunciante(nombreAnunciante));
        }
        if( tipoProducto != null && !tipoProducto.isEmpty() && !tipoProducto.equals("null")){
            predicado = predicado.and(buscarPorTipoProducto(tipoProducto));
        }


        return predicado;
    }
}
