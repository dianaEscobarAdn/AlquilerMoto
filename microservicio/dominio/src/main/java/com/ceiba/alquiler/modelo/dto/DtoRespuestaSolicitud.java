package com.ceiba.alquiler.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDate;

@Getter
@AllArgsConstructor
public class DtoRespuestaSolicitud {
    private Integer idSolicitud;
    private Integer idProducto;
    private Integer idPersona;
    private LocalDate fechaSolicitud;
    private Integer diasAlquiler;
    private LocalDate fechaDevolucion;
    private Double valorSolicitud;
    private Double valorDeposito;
}