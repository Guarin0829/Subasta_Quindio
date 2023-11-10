package co.edu.uniquindio.programacion3.subastaquindio.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Anunciante extends Persona implements Serializable {
    private static final long serialVersionUID = 1L;

    Usuario usuarioAsociado;

    ArrayList<Producto> listaProductos = new ArrayList<>();

    public Anunciante(){

    }

    public Anunciante(Usuario usuarioAsociado, ArrayList<Producto> listaProductos) {
        this.usuarioAsociado = usuarioAsociado;
        this.listaProductos = listaProductos;
    }

    public Usuario getUsuarioAsociado() {
        return usuarioAsociado;
    }

    public void setUsuarioAsociado(Usuario usuarioAsociado) {
        this.usuarioAsociado = usuarioAsociado;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void setListaProductos(ArrayList<Producto> listaProductos) {
        this.listaProductos = listaProductos;
    }
}
