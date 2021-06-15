package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.entidad.Producto;

public class ProductoTestDataBuilder {

    private Integer idProducto;
    private String codigoProducto;
    private String descripcionProducto;
    private Integer unidadesDisponibles;
    private Integer unidadesSolicitadas;

    public ProductoTestDataBuilder() {
        codigoProducto = "123456";
        descripcionProducto = "Moto Prueba Unitaria";
        unidadesDisponibles = 10;
        unidadesSolicitadas = 2;
    }

    public ProductoTestDataBuilder conCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
        return this;
    }

    public Producto build() {
        return new Producto(idProducto,codigoProducto, descripcionProducto,unidadesDisponibles,unidadesSolicitadas);
    }
}
