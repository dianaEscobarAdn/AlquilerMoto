package com.ceiba.alquiler.solicitud.servicio.testdatabuilder;

import com.ceiba.alquiler.comando.ComandoSolicitud;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ComandoSolicitudTestDataBuilder {

    private Integer idSolicitud;
    private Integer idProducto;
    private Integer idPersona;
    private LocalDate fechaSolicitud;
    private Integer diasAlquiler;
    private LocalDate fechaDevolucion;
    private Double valorSolicitud;
    private Double valorDeposito;

    public ComandoSolicitudTestDataBuilder() {
        idProducto = 1;
        idPersona = 1;
        fechaSolicitud = ParseoDeFechas("2021-06-16");
        diasAlquiler = 5;
    }

    public ComandoSolicitud build() {
        return new ComandoSolicitud(idSolicitud,idProducto, idPersona,fechaSolicitud,diasAlquiler,fechaDevolucion,valorSolicitud,valorDeposito);
    }

    private LocalDate ParseoDeFechas(String fecha){
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}