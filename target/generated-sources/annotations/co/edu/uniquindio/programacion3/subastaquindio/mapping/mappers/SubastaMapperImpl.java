package co.edu.uniquindio.programacion3.subastaquindio.mapping.mappers;

import co.edu.uniquindio.programacion3.subastaquindio.enumm.Rol;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.AnuncioDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ChatDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.CompradorDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.PujaDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.UsuarioDto;
import co.edu.uniquindio.programacion3.subastaquindio.model.Anunciante;
import co.edu.uniquindio.programacion3.subastaquindio.model.Anuncio;
import co.edu.uniquindio.programacion3.subastaquindio.model.Chat;
import co.edu.uniquindio.programacion3.subastaquindio.model.Comprador;
import co.edu.uniquindio.programacion3.subastaquindio.model.Producto;
import co.edu.uniquindio.programacion3.subastaquindio.model.Puja;
import co.edu.uniquindio.programacion3.subastaquindio.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/*
@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-11-21T16:01:40-0500",
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

        ProductoDTO productoDTO = new ProductoDTO( codigoUnico, nombreProducto, tipoProducto, foto, nombreAnunciante );

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
        String contrasenia = null;
        String direccion = null;
        String rol = null;
        String correo = null;
        String fechaNacimiento = null;
        String usuarioAsociado = null;

        nombre = anunciante.getNombre();
        apellido = anunciante.getApellido();
        cedula = anunciante.getCedula();
        telefono = anunciante.getTelefono();
        contrasenia = anunciante.getContrasenia();
        direccion = anunciante.getDireccion();
        rol = anunciante.getRol();
        correo = anunciante.getCorreo();
        fechaNacimiento = anunciante.getFechaNacimiento();
        usuarioAsociado = anunciante.getUsuarioAsociado();

        AnuncianteDto anuncianteDto = new AnuncianteDto( nombre, apellido, cedula, telefono, contrasenia, direccion, rol, correo, fechaNacimiento, usuarioAsociado );

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
        anunciante.setContrasenia( anuncianteDto.contrasenia() );
        anunciante.setApellido( anuncianteDto.apellido() );
        anunciante.setDireccion( anuncianteDto.direccion() );
        anunciante.setRol( anuncianteDto.rol() );
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
        String contrasenia = null;
        String direccion = null;
        String rol = null;
        String correo = null;
        String fechaNacimiento = null;
        String usuarioAsociado = null;

        nombre = comprador.getNombre();
        apellido = comprador.getApellido();
        cedula = comprador.getCedula();
        telefono = comprador.getTelefono();
        contrasenia = comprador.getContrasenia();
        direccion = comprador.getDireccion();
        rol = comprador.getRol();
        correo = comprador.getCorreo();
        fechaNacimiento = comprador.getFechaNacimiento();
        usuarioAsociado = comprador.getUsuarioAsociado();

        CompradorDto compradorDto = new CompradorDto( nombre, apellido, cedula, telefono, contrasenia, direccion, rol, correo, fechaNacimiento, usuarioAsociado );

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
        comprador.setContrasenia( compradorDto.contrasenia() );
        comprador.setApellido( compradorDto.apellido() );
        comprador.setDireccion( compradorDto.direccion() );
        comprador.setRol( compradorDto.rol() );
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

    @Override
    public AnuncioDto anuncioToAnuncioDto(Anuncio anuncio) {
        if ( anuncio == null ) {
            return null;
        }

        String codigo = null;
        String producto = null;
        String anunciante = null;
        String fechaPublicacion = null;
        String fechaFinPublicacion = null;
        String valorInicial = null;
        String descripcion = null;
        String foto = null;
        String estado = null;

        codigo = anuncio.getCodigo();
        producto = anuncio.getProducto();
        anunciante = anuncio.getAnunciante();
        fechaPublicacion = anuncio.getFechaPublicacion();
        fechaFinPublicacion = anuncio.getFechaFinPublicacion();
        valorInicial = anuncio.getValorInicial();
        descripcion = anuncio.getDescripcion();
        foto = anuncio.getFoto();
        estado = anuncio.getEstado();

        AnuncioDto anuncioDto = new AnuncioDto( codigo, producto, anunciante, fechaPublicacion, fechaFinPublicacion, valorInicial, descripcion, foto, estado );

        return anuncioDto;
    }

    @Override
    public Anuncio anuncioDtoToAnuncio(AnuncioDto anuncioDto) {
        if ( anuncioDto == null ) {
            return null;
        }

        Anuncio anuncio = new Anuncio();

        anuncio.setCodigo( anuncioDto.codigo() );
        anuncio.setProducto( anuncioDto.producto() );
        anuncio.setAnunciante( anuncioDto.anunciante() );
        anuncio.setFechaPublicacion( anuncioDto.fechaPublicacion() );
        anuncio.setFechaFinPublicacion( anuncioDto.fechaFinPublicacion() );
        anuncio.setValorInicial( anuncioDto.valorInicial() );
        anuncio.setDescripcion( anuncioDto.descripcion() );
        anuncio.setFoto( anuncioDto.foto() );
        anuncio.setEstado( anuncioDto.estado() );

        return anuncio;
    }

    @Override
    public List<AnuncioDto> getAnuncioDto(List<Anuncio> listaAnuncios) {
        if ( listaAnuncios == null ) {
            return null;
        }

        List<AnuncioDto> list = new ArrayList<AnuncioDto>( listaAnuncios.size() );
        for ( Anuncio anuncio : listaAnuncios ) {
            list.add( anuncioToAnuncioDto( anuncio ) );
        }

        return list;
    }

    @Override
    public PujaDto pujaToPujaDto(Puja puja) {
        if ( puja == null ) {
            return null;
        }

        String codigo = null;
        String producto = null;
        String anuncio = null;
        String comprador = null;
        String oferta = null;
        String estadoAnuncio = null;

        codigo = puja.getCodigo();
        producto = puja.getProducto();
        anuncio = puja.getAnuncio();
        comprador = puja.getComprador();
        oferta = String.valueOf( puja.getOferta() );
        estadoAnuncio = puja.getEstadoAnuncio();

        PujaDto pujaDto = new PujaDto( codigo, producto, anuncio, comprador, oferta, estadoAnuncio );

        return pujaDto;
    }

    @Override
    public Puja pujaDtoToPuja(PujaDto pujaDto) {
        if ( pujaDto == null ) {
            return null;
        }

        Puja puja = new Puja();

        puja.setCodigo( pujaDto.codigo() );
        puja.setComprador( pujaDto.comprador() );
        if ( pujaDto.oferta() != null ) {
            puja.setOferta( Double.parseDouble( pujaDto.oferta() ) );
        }
        puja.setProducto( pujaDto.producto() );
        puja.setAnuncio( pujaDto.anuncio() );
        puja.setEstadoAnuncio( pujaDto.estadoAnuncio() );

        return puja;
    }

    @Override
    public List<PujaDto> getPujaDto(List<Puja> listaPujas) {
        if ( listaPujas == null ) {
            return null;
        }

        List<PujaDto> list = new ArrayList<PujaDto>( listaPujas.size() );
        for ( Puja puja : listaPujas ) {
            list.add( pujaToPujaDto( puja ) );
        }

        return list;
    }

    @Override
    public ChatDto chatToChatDto(Chat chat) {
        if ( chat == null ) {
            return null;
        }

        String anunciante = null;
        String miChat = null;

        anunciante = chat.getAnunciante();
        miChat = chat.getMiChat();

        ChatDto chatDto = new ChatDto( anunciante, miChat );

        return chatDto;
    }

    @Override
    public Chat chatDtoToChat(ChatDto chatDto) {
        if ( chatDto == null ) {
            return null;
        }

        Chat chat = new Chat();

        chat.setAnunciante( chatDto.anunciante() );
        chat.setMiChat( chatDto.miChat() );

        return chat;
    }

    @Override
    public List<ChatDto> getChatDto(List<Chat> listaChats) {
        if ( listaChats == null ) {
            return null;
        }

        List<ChatDto> list = new ArrayList<ChatDto>( listaChats.size() );
        for ( Chat chat : listaChats ) {
            list.add( chatToChatDto( chat ) );
        }

        return list;
    }
}
