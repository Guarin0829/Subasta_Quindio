package co.edu.uniquindio.programacion3.subastaquindio.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Anunciante extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    String usuarioAsociado;

    ArrayList<Producto> listaProductos = new ArrayList<>();

    public Anunciante(){

    }

    public Anunciante(String usuarioAsociado, ArrayList<Producto> listaProductos) {
        this.usuarioAsociado = usuarioAsociado;
        this.listaProductos = listaProductos;
    }

    public String getUsuarioAsociado() {return usuarioAsociado;
    }

    public void setUsuarioAsociado(String usuarioAsociado) {this.usuarioAsociado = usuarioAsociado;}

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
