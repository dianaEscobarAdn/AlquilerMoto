package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoProducto;
import com.ceiba.alquiler.modelo.entidad.Producto;

import java.util.List;

public interface DaoProducto {

    /**
     * Permite listar producto
     * @return las productos
     */
    List<Producto> consultarProductos();

    Producto consultarProducto(Integer idProducto);
}
