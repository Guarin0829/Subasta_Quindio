package co.edu.uniquindio.programacion3.subastaquindio.controller;


import co.edu.uniquindio.programacion3.subastaquindio.controller.ModelFactoryController;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.AnuncianteDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.AnuncioDto;
import co.edu.uniquindio.programacion3.subastaquindio.mapping.dto.ProductoDTO;

import java.util.List;

public class AnuncioController {
    ModelFactoryController modelFactoryController;

    public AnuncioController(){
        modelFactoryController = ModelFactoryController.getInstance();
    }

    public List<AnuncioDto> obtenerAnuncios() {
        return modelFactoryController.obtenerAnuncios();
    }

    public List<ProductoDTO> obtenerProductos(){
        return modelFactoryController.obtenerProductos();
    }

    public List<AnuncianteDto> obtenerAnunciantes(){
        return modelFactoryController.obtenerAnunciantes();
    }

    public boolean agregarAnuncio(AnuncioDto anuncioDto) {
        return modelFactoryController.agregarAnuncio(anuncioDto);
    }

    public boolean eliminarAnuncio(String codigo) {
        return modelFactoryController.eliminarAnuncio(codigo);
    }

    public boolean actualizarAnuncio(String cedula, AnuncioDto anuncioDto) {
        return modelFactoryController.actualizarAnuncio(cedula, anuncioDto);
    }

    public void registrarAcciones(String mensaje, int nivel, String accion) {
        modelFactoryController.registrarAccionesSistema(mensaje, nivel, accion);
    }
}
