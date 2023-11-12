package co.edu.uniquindio.programacion3.subastaquindio.mapping.mappers;

import co.edu.uniquindio.programacion3.subastaquindio.enumm.Rol;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.CompradorDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.UsuarioDto;
import co.edu.uniquindio.programacion3.subastaquindio.model.Anunciante;
import co.edu.uniquindio.programacion3.subastaquindio.model.Comprador;
import co.edu.uniquindio.programacion3.subastaquindio.model.Producto;
import co.edu.uniquindio.programacion3.subastaquindio.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-12T13:28:33-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.1 (Oracle Corporation)"
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
        String tipoProducto = null;
        String foto = null;
        String nombreAnunciante = null;

        codigoUnico = producto.getCodigoUnico();
        nombreProducto = producto.getNombreProducto();
        tipoProducto = producto.getTipoProducto();
        foto = producto.getFoto();
        nombreAnunciante = producto.getNombreAnunciante();

        String descripcion = null;
        String fechaPublicacion = null;
        String fechaFinPublicacion = null;
        Double valorInicial = null;

        ProductoDTO productoDTO = new ProductoDTO( codigoUnico, nombreProducto, descripcion, tipoProducto, foto, nombreAnunciante, fechaPublicacion, fechaFinPublicacion, valorInicial );

        return productoDTO;
    }

    @Override
    public Producto productoDtoToProducto(ProductoDTO productoDto) {
        if ( productoDto == null ) {
            return null;
        }

        Producto producto = new Producto();

        producto.setNombreProducto( productoDto.nombreProducto() );
        producto.setTipoProducto( productoDto.tipoProducto() );
        producto.setFoto( productoDto.foto() );
        producto.setNombreAnunciante( productoDto.nombreAnunciante() );
        producto.setCodigoUnico( productoDto.codigoUnico() );

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

    @Override
    public UsuarioDto usuarioToUsuarioDto(Usuario usuario) {
        if ( usuario == null ) {
            return null;
        }

        String usuario1 = null;
        String contrasenia = null;
        String rol = null;

        usuario1 = usuario.getUsuario();
        contrasenia = usuario.getContrasenia();
        if ( usuario.getRol() != null ) {
            rol = usuario.getRol().name();
        }

        UsuarioDto usuarioDto = new UsuarioDto( usuario1, contrasenia, rol );

        return usuarioDto;
    }

    @Override
    public Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        Usuario usuario = new Usuario();

        usuario.setUsuario( usuarioDto.usuario() );
        usuario.setContrasenia( usuarioDto.contrasenia() );
        if ( usuarioDto.rol() != null ) {
            usuario.setRol( Enum.valueOf( Rol.class, usuarioDto.rol() ) );
        }

        return usuario;
    }

    @Override
    public List<UsuarioDto> getUsuarioDto(List<Usuario> listaUsuarios) {
        if ( listaUsuarios == null ) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>( listaUsuarios.size() );
        for ( Usuario usuario : listaUsuarios ) {
            list.add( usuarioToUsuarioDto( usuario ) );
        }

        return list;
    }

    @Override
    public AnuncianteDto anuncianteToAnuncianteDto(Anunciante anunciante) {
        if ( anunciante == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String cedula = null;
        String telefono = null;
        String direccion = null;
        String correo = null;
        String fechaNacimiento = null;
        String usuarioAsociado = null;

        nombre = anunciante.getNombre();
        apellido = anunciante.getApellido();
        cedula = anunciante.getCedula();
        telefono = anunciante.getTelefono();
        direccion = anunciante.getDireccion();
        correo = anunciante.getCorreo();
        fechaNacimiento = anunciante.getFechaNacimiento();
        usuarioAsociado = anunciante.getUsuarioAsociado();

        AnuncianteDto anuncianteDto = new AnuncianteDto( nombre, apellido, cedula, telefono, direccion, correo, fechaNacimiento, usuarioAsociado );

        return anuncianteDto;
    }

    @Override
    public Anunciante anuncianteDtoToAnunciante(AnuncianteDto anuncianteDto) {
        if ( anuncianteDto == null ) {
            return null;
        }

        Anunciante anunciante = new Anunciante();

        anunciante.setCedula( anuncianteDto.cedula() );
        anunciante.setNombre( anuncianteDto.nombre() );
        anunciante.setTelefono( anuncianteDto.telefono() );
        anunciante.setApellido( anuncianteDto.apellido() );
        anunciante.setDireccion( anuncianteDto.direccion() );
        anunciante.setCorreo( anuncianteDto.correo() );
        anunciante.setFechaNacimiento( anuncianteDto.fechaNacimiento() );
        anunciante.setUsuarioAsociado( anuncianteDto.usuarioAsociado() );

        return anunciante;
    }

    @Override
    public List<AnuncianteDto> getAnuncianteDto(List<Anunciante> listaAnunciantes) {
        if ( listaAnunciantes == null ) {
            return null;
        }

        List<AnuncianteDto> list = new ArrayList<AnuncianteDto>( listaAnunciantes.size() );
        for ( Anunciante anunciante : listaAnunciantes ) {
            list.add( anuncianteToAnuncianteDto( anunciante ) );
        }

        return list;
    }

    @Override
    public CompradorDto compradorToCompradorDto(Comprador comprador) {
        if ( comprador == null ) {
            return null;
        }

        String nombre = null;
        String apellido = null;
        String cedula = null;
        String telefono = null;
        String direccion = null;
        String correo = null;
        String fechaNacimiento = null;
        String usuarioAsociado = null;

        nombre = comprador.getNombre();
        apellido = comprador.getApellido();
        cedula = comprador.getCedula();
        telefono = comprador.getTelefono();
        direccion = comprador.getDireccion();
        correo = comprador.getCorreo();
        fechaNacimiento = comprador.getFechaNacimiento();
        usuarioAsociado = comprador.getUsuarioAsociado();

        CompradorDto compradorDto = new CompradorDto( nombre, apellido, cedula, telefono, direccion, correo, fechaNacimiento, usuarioAsociado );

        return compradorDto;
    }

    @Override
    public Comprador compradorDtoToComprador(CompradorDto compradorDto) {
        if ( compradorDto == null ) {
            return null;
        }

        Comprador comprador = new Comprador();

        comprador.setCedula( compradorDto.cedula() );
        comprador.setNombre( compradorDto.nombre() );
        comprador.setTelefono( compradorDto.telefono() );
        comprador.setApellido( compradorDto.apellido() );
        comprador.setDireccion( compradorDto.direccion() );
        comprador.setCorreo( compradorDto.correo() );
        comprador.setFechaNacimiento( compradorDto.fechaNacimiento() );
        comprador.setUsuarioAsociado( compradorDto.usuarioAsociado() );

        return comprador;
    }

    @Override
    public List<CompradorDto> getCompradorDto(List<Comprador> listaCompradores) {
        if ( listaCompradores == null ) {
            return null;
        }

        List<CompradorDto> list = new ArrayList<CompradorDto>( listaCompradores.size() );
        for ( Comprador comprador : listaCompradores ) {
            list.add( compradorToCompradorDto( comprador ) );
        }

        return list;
    }
}
