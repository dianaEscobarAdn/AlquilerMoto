package com.ceiba.alquiler;

import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;


public class ServicioCrearProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public Integer ejecutar(Producto producto) {
       // Integer idProducto = this.repositorioProducto.crear(producto);
       // Producto productoCreado = this.repositorioProducto.buscarProductoPorId(idProducto);
        return this.repositorioProducto.crear(producto);
    }
}
