package com.ceiba.alquiler.servicio.testdatabuilder;

import com.ceiba.alquiler.modelo.entidad.Solicitud;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class SolicitudTestDataBuilder {

    private Integer idSolicitud;
    private Integer idProducto;
    private Integer idPersona;
    private LocalDate fechaSolicitud;
    private Integer diasAlquiler;
    private LocalDate fechaDevolucion;
    private Double valorSolicitud;
    private Double valorDeposito;

    public SolicitudTestDataBuilder() {
        idProducto = 123456;
        idPersona = 123456;
        fechaSolicitud = ParseoDeFechas("2021-06-18");
        diasAlquiler = 5;
    }

    public Solicitud build() {
        return new Solicitud(idSolicitud,idProducto, idPersona,fechaSolicitud,diasAlquiler,fechaDevolucion,valorSolicitud,valorDeposito);
    }

    private LocalDate ParseoDeFechas(String fecha){
        return LocalDate.parse(fecha, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
