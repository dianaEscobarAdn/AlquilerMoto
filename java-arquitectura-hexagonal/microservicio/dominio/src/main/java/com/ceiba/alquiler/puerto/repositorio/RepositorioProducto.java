package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Producto;

public interface RepositorioProducto {
    /**
     * Permite crear un producto
     * @param producto
     * @return el id generado
     */
    Integer crear(Producto producto);

    /**
     * Permite validar si existe un producto por idProducto
     * @param idProducto
     * @return si existe o no
     */
    Producto buscarProductoPorId(Integer idProducto);
}
