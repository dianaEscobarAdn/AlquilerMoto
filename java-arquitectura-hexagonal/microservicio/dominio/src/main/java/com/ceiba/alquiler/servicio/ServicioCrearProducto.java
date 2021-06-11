package com.ceiba.alquiler.servicio;

import com.ceiba.alquiler.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.alquiler.modelo.entidad.Producto;
import com.ceiba.alquiler.puerto.repositorio.RepositorioProducto;


public class ServicioCrearProducto {

    private final RepositorioProducto repositorioProducto;

    public ServicioCrearProducto(RepositorioProducto repositorioProducto) {
        this.repositorioProducto = repositorioProducto;
    }

    public String ejecutar(Producto producto) {
        if(validarUnidadesDisponiblesContraUnidadesComprometidas(producto.getUnidadesComprometidas(),producto.getUnidadesDisponibles())){
            Integer idProducto = this.repositorioProducto.crear(producto);
            Producto productoCreada = this.repositorioProducto.buscarProductoPorId(idProducto);
            return "Se ha creado el producto correctamente, con código: " + productoCreada.getCodigoProducto()
                    + ", Descripción: " + productoCreada.getDescripcionProducto() + ", Unidades: " + productoCreada.getUnidadesDisponibles();
        }
        return "Error: Las unidades comprometidas no puede ser mayor a las unidades disponibles";
    }

    private boolean validarUnidadesDisponiblesContraUnidadesComprometidas(int unidadesComprometidas,int unidadesDisponibles) {
        return  unidadesComprometidas > unidadesDisponibles ? false : true;
    }
}
