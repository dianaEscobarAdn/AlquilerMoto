package com.ceiba.alquiler.servicio.producto;

import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;

public class ServicioEliminarProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioEliminarProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public void ejecutar(Integer idProducto) {
        this.repositorioProducto.eliminar(idProducto);
    }

}