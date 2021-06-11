package com.ceiba.alquiler.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoProducto;

public class ComandoProductoTestDataBuilder {

    private Integer idProducto;
    private String codigoProducto;
    private String descripcionProducto;
    private int unidadesDisponibles;
    private int unidadesComprometidas;

    public ComandoProductoTestDataBuilder() {
        codigoProducto = "12345";
        descripcionProducto = "Moto";
        unidadesDisponibles = 20;
        unidadesComprometidas = 5;
    }

    public ComandoProductoTestDataBuilder conCodigoProducto(String codigoProducto) {
        this.codigoProducto = codigoProducto;
        return this;
    }

    public ComandoProducto build() {
        return new ComandoProducto(idProducto,codigoProducto, descripcionProducto,unidadesDisponibles,unidadesComprometidas);
    }
}
