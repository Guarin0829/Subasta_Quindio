package co.edu.uniquindio.programacion3.subastaquindio.mapping.dto;

public record CompradorDto(
        String nombre,
        String apellido,
        String cedula,
        String telefono,
        String contrasenia,
        String direccion,
        String rol,
        String correo,
        String fechaNacimiento,
        String usuarioAsociado) {

    public UsuarioDto getUsuarioAsociado(){
        return new UsuarioDto(usuarioAsociado, "","");
    }
}
