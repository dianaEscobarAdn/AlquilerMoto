package com.ceiba.alquiler.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DtoRespuestaProducto {
    private int idProducto;
    private String codigoProducto;
    private String descripcionProducto;
    private int unidadesDisponibles;
    private int unidadesComprometidas;
}