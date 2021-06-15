package com.ceiba.alquiler.puerto.dao;

import com.ceiba.alquiler.modelo.dto.DtoProducto;

import java.util.List;

public interface DaoProducto {

    List<DtoProducto> consultarProductos();

}