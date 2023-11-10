package co.edu.uniquindio.programacion3.subastaquindio.mapping.mappers;

import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;
import co.edu.uniquindio.programacion3.subastaquindio.model.Producto;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-09T14:55:38-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Amazon.com Inc.)"
)
*/
public class SubastaMapperImpl implements SubastaMapper {

    @Override
    public ProductoDTO productoToProductoDto(Producto producto) {
        if ( producto == null ) {
            return null;
        }

        String codigoUnico = null;
        String nombreProducto = null;
        String descripcion = null;
        String tipoProducto = null;
        String foto = null;
        String fechaPublicacion = null;
        String fechaFinPublicacion = null;
        Double valorInicial = null;

        codigoUnico = producto.getCodigoUnico();
        nombreProducto = producto.getNombreProducto();
        descripcion = producto.getDescripcion();
        tipoProducto = producto.getTipoProducto();
        foto = producto.getFoto();
        fechaPublicacion = producto.getFechaPublicacion();
        fechaFinPublicacion = producto.getFechaFinPublicacion();
        valorInicial = producto.getValorInicial();

        String nombreAnunciante = null;

        ProductoDTO productoDTO = new ProductoDTO( codigoUnico, nombreProducto, descripcion, tipoProducto, foto, nombreAnunciante, fechaPublicacion, fechaFinPublicacion, valorInicial );

        return productoDTO;
    }

    @Override
    public Producto productoDtoToProducto(ProductoDTO productoDto) {
        if ( productoDto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setCodigoUnico( productoDto.codigoUnico() );
        producto.setNombreProducto( productoDto.nombreProducto() );
        producto.setTipoProducto( productoDto.tipoProducto() );
        producto.setDescripcion( productoDto.descripcion() );
        producto.setFoto( productoDto.foto() );
        producto.setFechaPublicacion( productoDto.fechaPublicacion() );
        producto.setFechaFinPublicacion( productoDto.fechaFinPublicacion() );
        if ( productoDto.valorInicial() != null ) {
            producto.setValorInicial( productoDto.valorInicial() );
        }

        return producto;
    }

    @Override
    public List<ProductoDTO> getProductoDto(List<Producto> listaProductos) {
        if ( listaProductos == null ) {
            return null;
        }

        List<ProductoDTO> list = new ArrayList<ProductoDTO>( listaProductos.size() );
        for ( Producto producto : listaProductos ) {
            list.add( productoToProductoDto( producto ) );
        }

        return list;
    }
}
