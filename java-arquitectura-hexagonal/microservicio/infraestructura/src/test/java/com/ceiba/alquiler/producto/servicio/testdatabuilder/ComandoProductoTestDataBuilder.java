package com.ceiba.alquiler.producto.servicio.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoProducto;

public class ComandoProductoTestDataBuilder {

    private Integer idProducto;
    private String codigoProducto;
    private String descripcionProducto;
    private Integer unidadesDisponibles;
    private Integer unidadesSolicitadas;

    public ComandoProductoTestDataBuilder() {
        codigoProducto = "123456";
        descripcionProducto = "Moto Prueba Unitaria";
        unidadesDisponibles = 10;
        unidadesSolicitadas = 2;
    }

    public ComandoProducto build() {
        return new ComandoProducto(idProducto,codigoProducto, descripcionProducto,unidadesDisponibles,unidadesSolicitadas);
    }
}