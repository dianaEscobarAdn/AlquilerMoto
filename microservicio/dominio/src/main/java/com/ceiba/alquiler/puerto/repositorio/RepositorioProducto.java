package com.ceiba.alquiler.puerto.repositorio;

import com.ceiba.alquiler.modelo.entidad.Producto;

public interface RepositorioProducto {


   Integer crear(Producto producto);

   Producto buscarProductoPorId(Integer idProducto);

   void actualizar(Producto producto);

   void eliminar(Integer id);
}